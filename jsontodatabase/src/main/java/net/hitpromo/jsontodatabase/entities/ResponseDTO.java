package net.hitpromo.jsontodatabase.entities;

import java.util.List;

public class ResponseDTO {
    private Product product;
    private List<StockDTO> stock;

    public ResponseDTO() {
    }

    public ResponseDTO(Product product, List<StockDTO> stock) {
        this.product = product;
        this.stock = stock;
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

    public void setStock(List<StockDTO> stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductResponseDTO [product=" + product + ", stock=" + stock + "]";
    }
}