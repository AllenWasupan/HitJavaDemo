package net.hitpromo.jsontodatabase.controllers;

import net.hitpromo.jsontodatabase.entities.Product;
import net.hitpromo.jsontodatabase.entities.ProductAttribute;
import net.hitpromo.jsontodatabase.entities.Attribute;
import net.hitpromo.jsontodatabase.entities.SKU;
import net.hitpromo.jsontodatabase.dto.ResponseDTO;
import net.hitpromo.jsontodatabase.dto.StockDTO;
import net.hitpromo.jsontodatabase.repositories.ProductRepository;
import net.hitpromo.jsontodatabase.repositories.SKURepository;
import net.hitpromo.jsontodatabase.repositories.ProductAttributeRepository;
import net.hitpromo.jsontodatabase.repositories.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EP3GetID {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductAttributeRepository productAttributeRepository;
	@Autowired
	private SKURepository skuRepository;
	@Autowired
	private AttributeRepository attributeRepository;

	@GetMapping("/find-id/{productId}")
	public ResponseEntity<ResponseDTO> getProductById(@PathVariable("productId") int productId) {
		System.out.println("Looking for productId: " + productId);
		Product product = productRepository.findById(productId).orElse(null);
		// Request failed if product is null
		if (product == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}

		List<StockDTO> stockList = new ArrayList<>();

		// Iterate through all the product attributes and make an attributeList
		List<ProductAttribute> pAList = productAttributeRepository.findByProductId(productId);
		

		// Map to group ProductAttributes by their position
		Map<Integer, List<ProductAttribute>> groupedAttributes = new HashMap<>();

		for (ProductAttribute pA : pAList) {
			int position = pA.getPosition(); // Assuming getPosition() method exists
			groupedAttributes.computeIfAbsent(position, k -> new ArrayList<>()).add(pA);
		}
		
		// Iterate through the grouped attributes and process them
		for (Map.Entry<Integer, List<ProductAttribute>> entry : groupedAttributes.entrySet()) {
			StockDTO stockDTO = new StockDTO();
			int position = entry.getKey();
			List<ProductAttribute> attributesAtPosition = entry.getValue();
			List<String> attributeList = new ArrayList<>();
			System.out.println("Position: " + position);
			for (ProductAttribute pA : attributesAtPosition) {
				int attributeID = pA.getAttributeValueId();
				Attribute attribute = attributeRepository.findById(attributeID).orElse(null);

				attributeList.add(attribute.getValue());
			}
			stockDTO.setAttributes(attributeList);

			SKU sku = skuRepository.findByProductId(productId).get(entry.getKey()-1);
			stockDTO.setSku(sku.getsku());
			stockDTO.setInventory(sku.getInventory());
			stockList.add(stockDTO);
		}
		

		List<SKU> skuList = skuRepository.findByProductId(productId);
		System.out.println("skuList: " + skuList);

		ResponseDTO responseDTO = new ResponseDTO(product, stockList);
		
		
		// Otherwise, return the product
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/find-all-products")
    public ResponseEntity<List<Product>> printAllProducts() {
        List<Product> products = productRepository.findAll();
        products.forEach(System.out::println);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}