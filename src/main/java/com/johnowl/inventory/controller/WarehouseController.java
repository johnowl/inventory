package com.johnowl.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.johnowl.inventory.model.InventoryService;
import com.johnowl.inventory.model.Warehouse;
import com.johnowl.inventory.validation.WarehouseValidator;

@Controller
@RequestMapping("/warehouses")
public class WarehouseController {

	private WarehouseValidator validator;
	private InventoryService service;

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(validator);		
	}
	
	@Autowired
	public WarehouseController(InventoryService service, WarehouseValidator validator) {
		this.service= service;
		this.validator = validator;
	}
	
	@GetMapping("")
	@ResponseBody
	public List<Warehouse> get() {					
		return service.getAll();			
	}
	
	@PostMapping("")
	@ResponseBody
	public Warehouse add(@Valid @RequestBody Warehouse warehouse) {
		service.addWarehouse(warehouse);
		return warehouse;
	}

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public List<ObjectError> handleException(BindException ex) {
		return ex.getAllErrors();
	}
	
}
