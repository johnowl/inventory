package com.johnowl.inventory.model;

public interface InventoryRepository {
	void addWarehouse(Warehouse warehouse);
	Warehouse getWarehouseById(String warehouseId);
	void updateWarehouse(String warehouseId, Warehouse warehouse);
	void deleteWarehouse(String warehouseId);
	void addItemToWarehouse(String warehouseId, Item item);
}
