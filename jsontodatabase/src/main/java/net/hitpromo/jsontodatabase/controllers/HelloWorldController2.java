package net.hitpromo.jsontodatabase.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController2 {
    @GetMapping("/returnstring/{string}")
    public ResponseEntity<String> returnInput(@PathVariable("string") String s) {
        System.out.println("String received: " + s);
        String response = "Input: " + s;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
