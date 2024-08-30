package net.hitpromo.jsontodatabase.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.hitpromo.jsontodatabase.entities.Product;

@RestController
public class EP2Inventory {

	@PostMapping("/profill-rest-api-dev/fulfillment/getInventory")
	public String createProduct(@RequestBody final Product product) {
		System.out.println(product);
		return "wow2!";
	}
	// Desgin script to iterate through all products and then all sku's and verify inventory data count
}