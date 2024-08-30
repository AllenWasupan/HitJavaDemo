package net.hitpromo.jsontodatabase.repositories;

import net.hitpromo.jsontodatabase.entities.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Integer> {
    List<ProductAttribute> findByProductId(int productId);
}