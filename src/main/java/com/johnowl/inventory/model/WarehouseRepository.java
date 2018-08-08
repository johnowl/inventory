package com.johnowl.inventory.model;

public interface WarehouseRepository {

	void addItem(Item item);
	void removeItem(String itemId);
	void updateItem(Item item);

}
