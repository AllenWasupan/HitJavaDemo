package net.hitpromo.jsontodatabase.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.hitpromo.jsontodatabase.entities.Product;

@JsonPropertyOrder({ "product_name", "product_description", "total_inventory", "stock" })
public class ResponseDTO {

    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("product_description")
    private String productDescription;
    @JsonProperty("total_inventory")
    private int totalInventory;

    private List<StockDTO> stock;

    public ResponseDTO() {
        System.out.println("ResponseDTO Empty Init");
    }

    public ResponseDTO(Product product, List<StockDTO> stock) {
        System.out.println("ResponseDTO with Product");
        this.productName = product.getProductName();
        this.productDescription = product.getProductDescription();
        this.totalInventory = product.getTotalInventory();
        this.stock = stock;
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
    
    public List<StockDTO> getstock() {
        return stock;
    }

    public void setstock(List<StockDTO> stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ResponseDTO [productName=" + productName + ", productDescription=" + productDescription
                + ", totalInventory=" + totalInventory + ", stock=" + stock + "]";
    }

    public Product makeProduct(int productId) {
        Product product = new Product(productId, productName, productDescription, totalInventory);
        return product;
    }

}