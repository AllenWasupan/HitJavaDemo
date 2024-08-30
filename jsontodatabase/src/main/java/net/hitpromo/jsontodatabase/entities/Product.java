package net.hitpromo.jsontodatabase.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final int id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "total_inventory")
	private int totalInventory;

	public Product(final int id, final String productName, final String productDescription, final int totalInventory) {
		this.id = id;
        this.productName = productName;
		this.productDescription = productDescription;
		this.totalInventory = totalInventory;
	}
    
	public Product() {
		this.id = 0;
		this.productName = null;
		this.productDescription = null;
		this.totalInventory = 0;
	}

	public int getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public int getTotalInventory() {
		return totalInventory;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public void setTotalInventory(int totalInventory) {
		this.totalInventory = totalInventory;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + productName + ", product_description=" + productDescription + ", total_inventory=" + totalInventory + "]";
	}

     
}