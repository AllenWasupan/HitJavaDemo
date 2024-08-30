package net.hitpromo.jsontodatabase.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int id;

    @Column(name = "attribute_id")
    private int attributeId;

    @Column(name = "value")
    private String value;

    public AttributeValue(int id, int attributeId, String value) {
        this.id = id;
        this.attributeId = attributeId;
        this.value = value;
    }


    public int getId() {
        return id;
    }

    public int getAttribute() {
        return attributeId;
    }
    
    public String getValue() {
        return value;
    }

    public void setAttribute(int attributeId) {
        this.attributeId = attributeId;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AttributeValue [id=" + id + ", attributeId=" + attributeId + ", value=" + value + "]";
    }

}