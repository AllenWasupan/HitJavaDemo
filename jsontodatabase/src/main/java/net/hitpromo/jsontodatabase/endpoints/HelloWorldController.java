package net.hitpromo.jsontodatabase.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import net.hitpromo.jsontodatabase.model.Product;

@RestController
public class HelloWorldController {

	@GetMapping("/")
	public String hello() {
		return "Hello World?";
	}
}