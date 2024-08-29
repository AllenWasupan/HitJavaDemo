package net.hitpromo.jsontodatabase.entities;

public class Product {

	private final String id;
	private final String product_name;
    private final String product_description;
    private final int total_inventory;

	public Product(final String id, final String product_name, final String product_description, final int total_inventory) {
		this.id = id;
        this.product_name = product_name;
		this.product_description = product_description;
		this.total_inventory = total_inventory;
		
	}
    
	public String getId() {
		return id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public int getTotal_inventory() {
		return total_inventory;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", product_description=" + product_description
				+ ", total_inventory=" + total_inventory + "]";
	}

     
}