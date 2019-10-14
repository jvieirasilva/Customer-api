package com.customer.demonstracao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.demonstracao.model.Customer;
import com.customer.demonstracao.repository.CustomerRepository;

@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<Customer> getAllUsers(@RequestParam("name") String name, @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize ) {
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		return customerRepository.findAll(name,pageable);
	}
	@RequestMapping(value = "/age/", method = RequestMethod.GET)
	public Page<Customer> getAllByAge(@RequestParam("age") Integer age, @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize ) {	
		  Pageable pageable = PageRequest.of(pageNumber,pageSize);
		  return  customerRepository.findByAge(age,pageable);
	}
	@RequestMapping(value = "/created/", method = RequestMethod.GET)
	public Page<Customer> getAllByCreateDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize ) {	
		  Pageable pageable = PageRequest.of(pageNumber,pageSize);
		  return  customerRepository.findAllCreatedDate("ISODate("+"'"+startDate +"T00:00:00.000Z')", "ISODate("+"'"+endDate+"T23:59:59.000Z')", pageable);
	}
	@RequestMapping(method = RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getByEmployeesId(@PathVariable(value = "id") String id) {
		 return customerRepository.findById(id)
		           .map(record -> ResponseEntity.ok().body(record))
		           .orElse(ResponseEntity.notFound().build());
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") String id,
			@RequestBody Customer customer) {
		return customerRepository.findById(id)
		        .map(record -> {
		        	Customer customerUpdated = customerRepository.save(customer);
		            return ResponseEntity.ok().body(customerUpdated);
		        }).orElse(ResponseEntity.notFound().build());
		        
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> addEmployee(@PathVariable(value = "id") String id) {
		return customerRepository.findById(id)
		        .map(record -> {
		        	customerRepository.deleteById(id);
		            return ResponseEntity.ok().build();
		        }).orElse(ResponseEntity.notFound().build());
	}
}