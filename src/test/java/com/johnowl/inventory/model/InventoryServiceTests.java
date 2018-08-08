package com.johnowl.inventory.model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;


public class InventoryServiceTests {

	@Test
	public void addWarehouse_Succesfully() {
		
		InventoryRepository repository = mock(InventoryRepository.class);
		InventoryService service = new InventoryService(repository);
		
		Warehouse warehouse = new Warehouse();
		service.addWarehouse(warehouse);
		
		verify(repository, times(1)).addWarehouse(warehouse);
		
	}
	
	@Test
	public void updateWarehouse_Succesfully() {
		InventoryRepository repository = mock(InventoryRepository.class);		
		InventoryService service = new InventoryService(repository);
		
		Warehouse warehouse = new Warehouse();
		String id = "564214bb-48fc-43ff-853f-1146d89e2aa4";
		
		when(repository.getWarehouseById(id)).thenReturn(new Warehouse());
		
		service.updateWarehouse(id, warehouse);
		
		verify(repository, times(1)).updateWarehouse(id, warehouse);
	}
	
	@Test(expected=WarehouseNotFoundException.class)
	public void updateWarehouse_ShouldThrowWarehouseNotFoundException_WhenWarehouseDoesntExist() {
		InventoryRepository repository = mock(InventoryRepository.class);		
		InventoryService service = new InventoryService(repository);
		
		Warehouse warehouse = new Warehouse();
		String id = "564214bb-48fc-43ff-853f-1146d89e2aa4";
		
		when(repository.getWarehouseById(id)).thenReturn(null);
		
		service.updateWarehouse(id, warehouse);
		
	}
	
	@Test()
	public void deleteWarehouseById_Successfully() {
		InventoryRepository repository = mock(InventoryRepository.class);		
		InventoryService service = new InventoryService(repository);
		
		String id = "564214bb-48fc-43ff-853f-1146d89e2aa4";
		
		service.deleteWarehouseById(id);
		
		verify(repository, times(1)).deleteWarehouse(id);
		
	}
	
	@Test()
	public void getWarehouseById_Successfully() {
		InventoryRepository repository = mock(InventoryRepository.class);		
		InventoryService service = new InventoryService(repository);
		
		String id = "564214bb-48fc-43ff-853f-1146d89e2aa4";
		
		service.getWarehouseById(id);
		
		verify(repository, times(1)).getWarehouseById(id);
		
	}
	
	@Test
	public void addItemToWarehouse_Successfully() {
		InventoryRepository repository = mock(InventoryRepository.class);		
		InventoryService service = new InventoryService(repository);
		
		String warehouseId = "564214bb-48fc-43ff-853f-1146d89e2aa4";
		Item item = new Item(500);
		
		when(repository.getWarehouseById(warehouseId)).thenReturn(new Warehouse());
		
		service.addItemToWarehouse(warehouseId, item);
		
		verify(repository, times(1)).addItemToWarehouse(warehouseId, item);
	}
	
	@Test(expected=WarehouseNotFoundException.class)
	public void addItemToWarehouse_ShouldThrowWarehouseNotFoundException_WhenWarehouseDoesntExist() {
		InventoryRepository repository = mock(InventoryRepository.class);		
		InventoryService service = new InventoryService(repository);
		
		String warehouseId = "564214bb-48fc-43ff-853f-1146d89e2aa4";
		Item item = new Item(500);
		
		when(repository.getWarehouseById(warehouseId)).thenReturn(null);
		
		service.addItemToWarehouse(warehouseId, item);
		
		verify(repository, times(1)).addItemToWarehouse(warehouseId, item);
	}
}
