package net.hitpromo.jsontodatabase.controllers;

import net.hitpromo.jsontodatabase.entities.Product;
import net.hitpromo.jsontodatabase.repositories.AttributeRepository;
import net.hitpromo.jsontodatabase.repositories.ProductAttributeRepository;
import net.hitpromo.jsontodatabase.repositories.ProductRepository;
import net.hitpromo.jsontodatabase.repositories.SKURepository;
import net.hitpromo.jsontodatabase.dto.ResponseDTO;
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
    public ResponseDTO createOrUpdateProduct(@RequestBody final ResponseDTO responseDTO) {
        System.out.println("We are in the upload method");

        Product p = responseDTO.makeProduct(1);
        productRepository.save(p);

        System.out.println(responseDTO);
        return responseDTO;
    }
}