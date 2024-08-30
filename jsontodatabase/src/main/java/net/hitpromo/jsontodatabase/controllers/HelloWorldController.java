package net.hitpromo.jsontodatabase.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import net.hitpromo.jsontodatabase.model.Product;

@RestController
public class HelloWorldController {

	@GetMapping("/helloworld")
	public String hello() {
		return "Hello World?";
	}
}