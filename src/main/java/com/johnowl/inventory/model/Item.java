package com.johnowl.inventory.model;

public class Item {

	private String id;
	private String name;
	private float amount;

	public Item(String id, float amount) {
		this.id = id;
		this.amount = amount;
	}
	
	public Item(float initialAmount) {
		this.amount = initialAmount;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public float getAmount() {
		return amount;
	}

}
