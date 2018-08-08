package com.johnowl.inventory.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.johnowl.inventory.model.Warehouse;

@Component
public class WarehouseValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Warehouse.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
	}

}
