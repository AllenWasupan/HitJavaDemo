package net.hitpromo.jsontodatabase.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.hitpromo.jsontodatabase.entities.Product;
import net.hitpromo.jsontodatabase.repositories.ProductRepository;

public class ResponseDTO {
    @Autowired
    private ProductRepository productRepository;

    private int productId;

    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("product_description")
    private String productDescription;
    @JsonProperty("total_inventory")
    private int totalInventory;


    private Product product;
    private List<StockDTO> stock;

    public ResponseDTO() {
        System.out.println("ResponseDTO Empty Init");
    }

    public ResponseDTO(Product product) {
        this.product = product;
        
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<StockDTO> getStock() {
        return stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public void setStock(List<StockDTO> stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductResponseDTO [product=" + product + ", stock=" + stock + "]";
    }

    public Product makeProduct() {
        System.out.println("Making Product + " + productRepository.count());
        int c = (int)productRepository.count()+1;
        productId = c;
        Product product = new Product(productId, productName, productDescription, totalInventory);
        return product;
    }
}