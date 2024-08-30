package net.hitpromo.jsontodatabase.repositories;

import net.hitpromo.jsontodatabase.entities.SKU;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SKURepository extends JpaRepository<SKU, Integer> {
    List<SKU> findByProductId(int productId);

    SKU findByProductIdAndSku(int productId, String sku);
}