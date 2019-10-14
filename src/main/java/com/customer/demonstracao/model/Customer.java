package com.customer.demonstracao.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "customer")
public class Customer {
	
	@Id
	@Field("_id")
	private String id;
	
	@Field("firstName")
	private String firstName;
	
	@Field("lastName")
	private String lastName;
	
	@Field("cellPhone")
	private String cellPhone;
	
	@Field("email")
	private String email;
	
	@Field("age")
	private Integer age;
	
	@Field("address")
	private List<Address> address = new ArrayList<Address>();

}
