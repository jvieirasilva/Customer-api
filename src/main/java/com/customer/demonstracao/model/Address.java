package com.customer.demonstracao.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
	
	@Field("street")
	private String street;
	@Field("complement")
	private String complement;
	@Field("city")
	private String city;
	@Field("state")
	private String state; 
	@Field("zipCode")
	private String zipCode; 

}
