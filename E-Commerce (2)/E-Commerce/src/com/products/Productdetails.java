package com.products;

public class Productdetails {
	private int productid;
	private String description;
	private double price;
	private String name;
	private int quantity;

	public int getProductid() {
		return productid;
	}

	
	

	@Override
	public String toString() {
		return "Productdetails [productid=" + productid + ", description=" + description + ", price=" + price
				+ ", name=" + name + ", quantity=" + quantity + "]";
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
