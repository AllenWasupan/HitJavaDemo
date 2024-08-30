package net.hitpromo.jsontodatabase.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.hitpromo.jsontodatabase.entities.Product;
import net.hitpromo.jsontodatabase.repositories.ProductRepository;

public class ProductDTO {
    @Autowired
    private ProductRepository productRepository;

    private int productId;

    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("product_description")
    private String productDescription;
    @JsonProperty("total_inventory")
    private int totalInventory;

    public ProductDTO() {
        // Default constructor
        int c = (int)productRepository.count()+1;
        productId = c;
    }

    public ProductDTO(String productName, String productDescription, int totalInventory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.totalInventory = totalInventory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(int totalInventory) {
        this.totalInventory = totalInventory;
    }

    @Override
    public String toString() {
        return "ProductDTO [productName=" + productName + ", productDescription=" + productDescription + ", totalInventory=" + totalInventory + "]";
    }
    public Product getProduct() {
        Product product = new Product(productId, productName, productDescription, totalInventory);
        return product;
    }
}