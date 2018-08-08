package com.johnowl.inventory.model;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

	private InventoryRepository repository;

	public InventoryService(InventoryRepository repository) {
		this.repository = repository;
	}

	public Warehouse getWarehouseById(String id) {
		return this.repository.getWarehouseById(id);
	}

	public void addWarehouse(Warehouse warehouse) {		
		this.repository.addWarehouse(warehouse);
	}

	@Transactional
	public void updateWarehouse(String warehouseId, Warehouse warehouse) {

		Warehouse dbWarehouse = this.repository.getWarehouseById(warehouseId);
		if (dbWarehouse == null) {
			throw new WarehouseNotFoundException();
		}

		this.repository.updateWarehouse(warehouseId, warehouse);
	}

	public void deleteWarehouseById(String warehouseId) {
		this.repository.deleteWarehouse(warehouseId);
	}
	
	// mover método para classe warehouse
	@Transactional
	public void addItemToWarehouse(String warehouseId, Item item) {

		Warehouse warehouse = this.repository.getWarehouseById(warehouseId);
		if (warehouse == null) {
			throw new WarehouseNotFoundException();
		}

		this.repository.addItemToWarehouse(warehouseId, item);
	}

	public List<Warehouse> getAll() {
		return null;
	}

}
