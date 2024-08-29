package net.hitpromo.jsontodatabase.endpoints;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.hitpromo.jsontodatabase.model.Product;

@RestController
public class EP3GetID {

	@PostMapping("/find-id")
	public String createProduct(@RequestBody final Product product) {
		System.out.println(product);
		return "wow3!";
	}
}