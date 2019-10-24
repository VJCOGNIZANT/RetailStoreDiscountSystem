package com.xabia.retailstorediscountsystem.model;

public class ProductDetails {
	
	private int prdId;
	private String name;
	private boolean isGrocery;
	private int price;
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGrocery() {
		return isGrocery;
	}
	public void setGrocery(boolean isGrocery) {
		this.isGrocery = isGrocery;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
