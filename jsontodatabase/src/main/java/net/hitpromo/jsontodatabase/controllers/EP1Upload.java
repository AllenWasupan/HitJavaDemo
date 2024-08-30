package net.hitpromo.jsontodatabase.controllers;

import net.hitpromo.jsontodatabase.entities.Attribute;
import net.hitpromo.jsontodatabase.entities.Product;
import net.hitpromo.jsontodatabase.entities.ProductAttribute;
import net.hitpromo.jsontodatabase.entities.SKU;
import net.hitpromo.jsontodatabase.repositories.AttributeRepository;
import net.hitpromo.jsontodatabase.repositories.ProductAttributeRepository;
import net.hitpromo.jsontodatabase.repositories.ProductRepository;
import net.hitpromo.jsontodatabase.repositories.SKURepository;
import net.hitpromo.jsontodatabase.dto.ResponseDTO;
import net.hitpromo.jsontodatabase.dto.StockDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EP1Upload {
    @Autowired
	private ProductRepository productRepository;
    @Autowired
    private SKURepository skuRepository;
    @Autowired
    private AttributeRepository attributeRepository;
    @Autowired
    private ProductAttributeRepository productAttributeRepository;
    
    @PostMapping("/upload")
    public String createOrUpdateProduct(@RequestBody final ResponseDTO responseDTO) {
        // Create a new product and save it
        int productId = (int)productRepository.count()+1;
        System.out.println("Product ID: " + productId);
        Product product = responseDTO.makeProduct(productId);
        Product existingProduct = productRepository.findByProductNameAndProductDescription(product.getProductName(),product.getProductDescription());
        if (existingProduct != null) {
            // Update the existing product
            productId = existingProduct.getId();
            product = new Product(productId, product.getProductName(), product.getProductDescription(), product.getTotalInventory());
        }
        productRepository.save(product);

        // For each stock in the responseDTO, create a new SKU, productAttribute and save it
        List<StockDTO> stockList = responseDTO.getstock();
        int paId = (int)productAttributeRepository.count()+1;
        for (int i = 0; i < stockList.size(); i++) {
            System.out.println("Stock: " + stockList.get(i));
            // SKU setup
            String s = stockList.get(i).getSku();
            int inventory = stockList.get(i).getInventory();
            
            SKU existingSKU = skuRepository.findByProductIdAndSku(productId,s);
            int skuId;
            if (existingProduct != null) {
                // Update the existing product
                skuId = existingSKU.getId();
            }
            else {
                skuId = (int)skuRepository.count()+1;
            }
            SKU sku = new SKU(skuId,productId,s,inventory);
            skuRepository.save(sku);

            // Attribute setup
            // For each attribute in the stock, check if it exists in the database or save it
            List<String> attributes = stockList.get(i).getAttributes();
            for (String attributeValue : attributes) {
                System.out.println("AttributeVal: " + attributeValue);
                Attribute attribute = attributeRepository.findByValue(attributeValue);
                if (attribute == null) {
                    // Attribute does not exist, create and save it
                    attribute = new Attribute();
                    attribute.setValue(attributeValue);
                    attributeRepository.save(attribute);
                }
                // TODO: Check if is already in the productAttribute table
                // TODO: Why does the Id order change after I add attribute 8
                // Create and save ProductAttribute
                
                int position = i+1;
                ProductAttribute existingProductAttribute = productAttributeRepository.findByProductIdAndAttributeValueIdAndPosition(productId, attribute.getId(), position);
                ProductAttribute productAttribute = new ProductAttribute(paId,productId, attribute.getId(), position);
                if (existingProductAttribute == null) {
                    // Create and save ProductAttribute if it does not exist
                    productAttributeRepository.save(productAttribute);
                    System.out.println("Adding Product Attribute: " + productAttribute);
                    paId++;
                } else {
                    System.out.println("Product Attribute already exists: " + existingProductAttribute);
                }
                paId++;
            }
        }
        //productAttributeRepository.SortById();
        return "Saved or Updated " + product.getProductName() + "\n" + responseDTO;
    }
}