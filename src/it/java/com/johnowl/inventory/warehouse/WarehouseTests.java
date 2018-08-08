package com.johnowl.inventory.warehouse;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.johnowl.inventory.model.Warehouse;

public class WarehouseTests {

	private String baseUrl = "http://localhost:8080";
	private RestTemplate rest;

	@Before
	public void setup() {
		rest = new RestTemplate();
	}

	@Test(expected = HttpClientErrorException.class)
	public void shoudReturnClientErrorWhenWarehouseIsEmpty() {
		HttpEntity<Warehouse> request = new HttpEntity<>(new Warehouse());
		rest.postForEntity(baseUrl + "/warehouses", request, String.class);
	}

	@Test(expected = HttpClientErrorException.class)
	public void shoudReturnClientErrorWhenWarehouseIsNull() {
		HttpEntity<Warehouse> request = new HttpEntity<>(null);
		rest.postForEntity(baseUrl + "/warehouses", request, String.class);
	}

	@Test
	public void shoudReturnListOfWarehouse() {
		ResponseEntity<Warehouse[]> response = rest.getForEntity(baseUrl + "/warehouses", Warehouse[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(1, response.getBody().length);
	}

}
