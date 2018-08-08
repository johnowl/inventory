package com.johnowl.inventory.model;

public class WarehouseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8769576446336944143L;
	
	public WarehouseNotFoundException() {
		super("Warehouse not found.");
	}
}
