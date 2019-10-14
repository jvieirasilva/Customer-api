package com.customer.demonstracao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.demonstracao.model.Customer;
import com.customer.demonstracao.model.DatabaseSequence;

@Repository
public interface  DataBaseSequenceRepository extends MongoRepository<DatabaseSequence, String> {

}
