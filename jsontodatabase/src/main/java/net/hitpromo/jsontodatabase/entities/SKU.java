package net.hitpromo.jsontodatabase.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SKU {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private final String id;
	
	@Column(name = "product_id")
	private String productId;

	@Column(name = "sku")
	private String sku;

	@Column(name = "inventory")
	private int inventory;

	public SKU(final String id, final String productId, final String sku, final int inventory) {
		this.id = id;
        this.productId = productId;
		this.sku = sku;
		this.inventory = inventory;
	}
    
	public String getId() {
		return id;
	}

	public String getproduct_id() {
		return productId;
	}

	public String getsku() {
		return sku;
	}

	public int getInventory() {
		return inventory;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + productId + ", sku=" + sku + ", inventory=" + inventory + "]";
	}

     
}