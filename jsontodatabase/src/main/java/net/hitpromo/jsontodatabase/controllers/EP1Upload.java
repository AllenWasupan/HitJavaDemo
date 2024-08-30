package net.hitpromo.jsontodatabase.controllers;

import net.hitpromo.jsontodatabase.entities.Product;
import net.hitpromo.jsontodatabase.repositories.AttributeRepository;
import net.hitpromo.jsontodatabase.repositories.ProductAttributeRepository;
import net.hitpromo.jsontodatabase.repositories.ProductRepository;
import net.hitpromo.jsontodatabase.repositories.SKURepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.hitpromo.jsontodatabase.dto.ResponseDTO;


@RestController
public class EP1Upload {

    @PostMapping("/upload")
    public ResponseDTO createOrUpdateProduct(@RequestBody final ResponseDTO responseDTO) {
        System.out.println("We are in the upload method");
        responseDTO.makeProduct();
        System.out.println(responseDTO);
        System.out.println("Product: " + responseDTO.getProduct());
        System.out.println("Product Name: " + responseDTO.getProductName());
        System.out.println("Stock: " + responseDTO.getStock());
        return responseDTO;
    }
}