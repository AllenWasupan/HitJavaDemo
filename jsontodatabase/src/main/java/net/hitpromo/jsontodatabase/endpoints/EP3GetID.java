package net.hitpromo.jsontodatabase.endpoints;

import net.hitpromo.jsontodatabase.entities.Product;
import net.hitpromo.jsontodatabase.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EP3GetID {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/find-id/{productId}")
	public Product getProductById(@PathVariable int productId) {
		return productRepository.findById(productId).orElse(null);
	}
}