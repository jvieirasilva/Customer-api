package com.customer.demonstracao.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.demonstracao.model.Pets;

@Repository
public interface  PetsRepository extends MongoRepository<Pets, String> {
	
	Pets findBy_id(ObjectId _id);

}
