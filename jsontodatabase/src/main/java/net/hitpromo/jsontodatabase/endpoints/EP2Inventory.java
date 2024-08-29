package net.hitpromo.jsontodatabase.endpoints;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.hitpromo.jsontodatabase.model.Product;

@RestController
public class EP2Inventory {

	@PostMapping("/profill-rest-api-dev/fulfillment/getInventory")
	public String createProduct(@RequestBody final Product product) {
		System.out.println(product);
		return "wow2!";
	}
}