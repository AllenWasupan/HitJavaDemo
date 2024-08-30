package net.hitpromo.jsontodatabase.repositories;

import net.hitpromo.jsontodatabase.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByProductNameAndProductDescription(String productName, String productDescription);
    
}