package com.johnowl.inventory.model;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class Warehouse {

	private WarehouseRepository repository;
	private String id;
	private String name;

	public Warehouse() {
		this.id = UUID.randomUUID().toString();
	}
	
	@Autowired
	public Warehouse(WarehouseRepository repository) {
		this();
		this.repository = repository;
	}
	
	public Warehouse(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Transactional
	public void transferItemTo(Item item, String destinatioWarehouseId) {
		
	}
	
	public void addItem(Item item) {
		repository.addItem(item);
	}
	
	public void updateItem(Item item) {
		repository.updateItem(item);
	}
	
	public void removeItem(String itemId) {
		repository.removeItem(itemId);
	}

}
