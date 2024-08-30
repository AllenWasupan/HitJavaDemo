package net.hitpromo.jsontodatabase.controllers;

import net.hitpromo.jsontodatabase.entities.Product;
import net.hitpromo.jsontodatabase.entities.ProductAttribute;
import net.hitpromo.jsontodatabase.entities.AttributeValue;
import net.hitpromo.jsontodatabase.repositories.ProductRepository;
import net.hitpromo.jsontodatabase.repositories.ProductAttributeRepository;
import net.hitpromo.jsontodatabase.repositories.AttributeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EP3GetID {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductAttributeRepository productAttributeRepository;

	@Autowired
	private AttributeValueRepository attributeValueRepository;

	@GetMapping("/find-id/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") int productId) {
		System.out.println("productId: " + productId);
		Product p = productRepository.findById(productId).orElse(null);
		List<ProductAttribute> pAList = productAttributeRepository.findByProductId(productId);
		
		System.out.println("product: " + p);
		System.out.println("productAttribute: " + pAList);
		System.out.println("pACount: " + productAttributeRepository.count());
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/print-all-products")
    public ResponseEntity<List<Product>> printAllProducts() {
        List<Product> products = productRepository.findAll();
        products.forEach(System.out::println);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
/*
		List<AttributeValue> aVList = attributeValueRepository.findAll();
   		//For every product attribute, get the attribute value
		for (int i = 0; i < pAList.size(); i++) {
			int pos = pAList.get(i).getPosition();
			String s = aVList.get(pAList.get(i).getAttributeValue()).getValue();
			
		}
		System.out.println("product: " + p);
		System.out.println("productAttribute: " + pAList.get(3));
 */