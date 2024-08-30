package net.hitpromo.jsontodatabase.controllers;

import net.hitpromo.jsontodatabase.entities.Product;
import net.hitpromo.jsontodatabase.entities.ResponseDTO;
import net.hitpromo.jsontodatabase.entities.StockDTO;
import net.hitpromo.jsontodatabase.repositories.AttributeValueRepository;
import net.hitpromo.jsontodatabase.repositories.ProductAttributeRepository;
import net.hitpromo.jsontodatabase.repositories.ProductRepository;
import net.hitpromo.jsontodatabase.repositories.SKURepository;

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
    private ProductAttributeRepository productAttributeRepository;
    @Autowired
    private AttributeValueRepository attributeValueRepository;
    @Autowired
    private SKURepository skuRepository;

    @PostMapping("/upload")
    public String createOrUpdateProduct(@RequestBody final ResponseDTO responseDTO) {
        Product product = responseDTO.getProduct();
        List<StockDTO> stock = responseDTO.getStock();
        try {
            productRepository.save(product);
            for (StockDTO stockDTO : stock) {
                
                // Save stock data
                // Save to SKURepository (id = SKURepository.count()-1, sku = stockDTO.getSku(), inventory = stockDTO.getInventory())
                // Check if attributes exist in AttributeValueRepository, if not add to end of list
                // Do a nested for loop i to interate each position and j iterate through all attributes
                    // Save to ProductAttributeRepository (id = ProductAttributeRepository.count()-1, productId = product.getId(), attributeValueId = stock.getAttributes(j), position = i)
                // Check
            }
            return "Product successfully created or updated!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}