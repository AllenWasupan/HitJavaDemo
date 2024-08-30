package net.hitpromo.jsontodatabase.repositories;

import net.hitpromo.jsontodatabase.entities.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeValueRepository extends JpaRepository<AttributeValue, Integer> {

}