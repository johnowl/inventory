package com.johnowl.inventory.repository;

import org.springframework.stereotype.Repository;

import com.johnowl.inventory.model.InventoryRepository;
import com.johnowl.inventory.model.Item;
import com.johnowl.inventory.model.Warehouse;

@Repository
public class H2InventoryRepository implements InventoryRepository {

	@Override
	public void addWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Warehouse getWarehouseById(String warehouseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateWarehouse(String warehouseId, Warehouse warehouse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWarehouse(String warehouseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItemToWarehouse(String warehouseId, Item item) {
		// TODO Auto-generated method stub
		
	}

}
