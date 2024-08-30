package net.hitpromo.jsontodatabase.entities;

import java.util.List;

public class StockDTO {
    private List<String> attributes;
    private int inventory;

    public StockDTO() {
    }

    public StockDTO(List<String> attributes, int inventory) {
        this.attributes = attributes;
        this.inventory = inventory;
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