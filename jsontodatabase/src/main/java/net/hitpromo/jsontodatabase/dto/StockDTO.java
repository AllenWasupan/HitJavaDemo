package net.hitpromo.jsontodatabase.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StockDTO {

    @JsonProperty("attributes")
    private List<String> attributes;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("inventory")
    private int inventory;


    public StockDTO() {
    }

    public StockDTO(List<String> attributes, String sku, int inventory) {
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

}