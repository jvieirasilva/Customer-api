package com.customer.demonstracao.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "customer")
@AllArgsConstructor()
@NoArgsConstructor()
public class Customer {
	
	@Id
	@Field("_id")
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String cellPhone;
	
	private String email;
	
	private Integer age;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date createDate = new Date();
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date updateDate = new Date();
	
	private Address address = new Address();

}
