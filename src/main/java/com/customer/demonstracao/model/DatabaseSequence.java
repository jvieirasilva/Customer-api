package com.customer.demonstracao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "database_sequences")
public class DatabaseSequence {
 
    @Id
    private String id;
  
    @Field("seq_customer")
    private long seqCustomer;
 
}