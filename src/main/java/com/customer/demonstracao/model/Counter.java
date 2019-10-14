package com.customer.demonstracao.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "counters")
public class Counter {
  @Id private String id;
  private int seq;
  /* getters & setters .. */
}