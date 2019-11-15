package com.customer.demonstracao.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.customer.demonstracao.model.Counter;
 
@Service
public class CounterService {
  @Autowired private MongoOperations mongo;
   
  public int getNextSequence(String collectionName) {
 
    Counter counter = mongo.findAndModify(
      query(where("_id").is(collectionName)), 
      new Update().inc("seq", 1),
      options().returnNew(true),
      Counter.class);
       
    //return counter.getSeq();
    return 0;
  }
}