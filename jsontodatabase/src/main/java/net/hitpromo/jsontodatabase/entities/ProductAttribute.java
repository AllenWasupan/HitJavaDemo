package net.hitpromo.jsontodatabase.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "attribute_value_id")
    private int attributeValueId;

    @Column(name = "position")
    private int position;

    public ProductAttribute(int id, int productId, int attributeValueId, int position) {
        this.id = id;
        this.productId = productId;
        this.attributeValueId = attributeValueId;
        this.position = position;
    }

    public ProductAttribute() {
        this.id = 0;
        this.productId = 0;
        this.attributeValueId = 0;
        this.position = 0;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getAttributeValueId() {
        return attributeValueId;
    }

    public int getPosition() {
        return position;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }



    public void setAttributeValueId(int attributeValueId) {
        this.attributeValueId = attributeValueId;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ProductAttribute [id=" + id + ", product=" + productId  + ", attributeValue="
                + attributeValueId + ", position=" + position + "]";
    }

    // Getters and Setters
}