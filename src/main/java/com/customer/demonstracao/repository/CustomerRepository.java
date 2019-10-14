package com.customer.demonstracao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.demonstracao.model.Customer;

@Repository
public interface  CustomerRepository extends MongoRepository<Customer, String> {
	
	@Query("{ \"firstName\" : { \"$regex\" : ?0 , \"$options\" : \"i\"}}")
	public Page<Customer>  findAll(String firstName, Pageable p);
	
	public Page<Customer>  findByAge(Integer age, Pageable p);
	
	
	//{"created_at":{$gt:ISODate("2013-04-30T00:00:00Z"),$lt:ISODate("2013-04-30T23:59:59Z")}}
	
	//@Query("{ \"created\":{$gte:ISODate(?0),$lte:ISODate(?1)}}")
	//@Query(value = "{'created':{ $gte: ?0, $lte: ?1}}")
	@Query(value = "{'address.created':{ $gte: ?0, $lte: ?1 }}")
	public Page<Customer>  findAllCreatedDate(String  startDate, String  endDate, Pageable p);

}
