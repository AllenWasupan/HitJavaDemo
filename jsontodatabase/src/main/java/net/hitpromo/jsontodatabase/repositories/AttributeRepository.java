package net.hitpromo.jsontodatabase.repositories;

import net.hitpromo.jsontodatabase.entities.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeRepository extends JpaRepository<Attribute, Integer> {

}