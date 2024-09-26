package net.hitpromo.jsontodatabase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import net.hitpromo.jsontodatabase.entities.Product;
import net.hitpromo.jsontodatabase.entities.SKU;
import net.hitpromo.jsontodatabase.repositories.ProductRepository;
import net.hitpromo.jsontodatabase.repositories.SKURepository;

@RestController
public class EP2Inventory {
	@Autowired
	private ProductRepository productRepository;
    @Autowired
    private SKURepository skuRepository;

	@PostMapping("/profill-rest-api-dev/fulfillment/getInventory")
	public String checkInventory(@RequestHeader("Host") final String host, 
								 @RequestHeader("token") final String token, 
								 @RequestHeader("Content-Type") final String contentType, 
								 @RequestHeader("Content-Length") final int contentLength) {
		// Check if the request is valid
		if(!host.equals("profillds.profillholdings.com:8443")) {
			return "Invalid Host";
		}
		if(!token.equals("K8TS_5K1M77Q~hu1")) {
			return "Invalid Token";
		}
		if(contentType.equals("application/json")) {
			return "Invalid Content Type";
		}
		if(contentLength != 4) {
			return "Invalid Content Length";
		}

		// Begin request
		// Check if the inventory count matches for all products between the Product and SKU tables
		List<Product> products = productRepository.findAll();

		for (Product product : products) {
			List<SKU> skus = skuRepository.findByProductId(product.getId());
			
			int skuInventorySum = skus.stream().mapToInt(SKU::getInventory).sum();
			// Check if the inventory count matches for all products between the Product and SKU tables
			if (skuInventorySum != product.getTotalInventory()) {
				System.out.println("Inventory mismatch for Product ID: " + product.getId() + 
								   " - Product Inventory: " + product.getTotalInventory() + 
								   ", SKU Inventory Sum: " + skuInventorySum);
				// Update the product inventory count to match the SKU inventory count
				System.out.println("Updating Product ID: " + product.getId() + " inventory count to: " + skuInventorySum);
				product.setTotalInventory(skuInventorySum);
			}
		}

		return "The inventory counts have been updated.";
	}
	

	
}