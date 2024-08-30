package net.hitpromo.jsontodatabase.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import net.hitpromo.jsontodatabase.repositories.AttributeRepository;
import net.hitpromo.jsontodatabase.repositories.ProductAttributeRepository;
import net.hitpromo.jsontodatabase.repositories.SKURepository;
import net.hitpromo.jsontodatabase.entities.SKU;
import net.hitpromo.jsontodatabase.entities.Product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockDTO {
    @Autowired
    private SKURepository skuRepository;
    @Autowired
    private AttributeRepository attributeRepository;
    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @JsonProperty("attributes")
    private List<String> attributes;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("inventory")
    private int inventory;

    private Product product;
    private int productId;

    public StockDTO() {
    }

    public StockDTO(int productId, List<String> attributes, String sku, int inventory) {
        this.productId = productId;
        this.attributes = attributes;
        this.sku = sku;
        this.inventory = inventory;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "StockDTO [attributes=" + attributes + ", inventory=" + inventory + "]";
    }

    // Saves SKU to SKURepository
    public void uploadSKU() {
        int c = (int)skuRepository.count() + 1;
        SKU skuEntity = new SKU(c, productId, sku, inventory);
        skuRepository.save(skuEntity);
    }

    // Saves AttributeValue to AttributeRepository
    public void uploadAttribute() {
        
    }

    // Saves ProductAttribute to ProductAttributeRepository
    public void uploadProductAttribute() {
        
    }

    // Uploads SKU, AttributeValue, and ProductAttribute to their respective repositories
    public void upload() {
        uploadSKU();
        uploadAttribute();
        uploadProductAttribute();
    }
}