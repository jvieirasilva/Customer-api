package com.customer.demonstracao.controller;
import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.demonstracao.model.Pets;
import com.customer.demonstracao.repository.PetsRepository;
@RestController
@RequestMapping("/api/pet")
public class PetsController {
  @Autowired
  private PetsRepository repository;
 
  @RequestMapping(method = RequestMethod.GET)
  public List<Pets> getAllPets() {
    return repository.findAll();
  }
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  //public Pets getPetById(@PathVariable(“id”) ObjectId id) {
  public Pets getPetById(@PathVariable(value = "id") ObjectId id) {	  
    return repository.findBy_id(id);
  }
 
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  //public void modifyPetById(@PathVariable(“id”) ObjectId id, @Valid @RequestBody Pets pets) {
  public void modifyPetById(@PathVariable(value = "id") ObjectId id, @Valid @RequestBody Pets pets) {	  	  
    pets.set_id(id);
    repository.save(pets);
  }
 
  @RequestMapping(method = RequestMethod.POST)
  public Pets createPet(@Valid @RequestBody Pets pets) {
    pets.set_id(ObjectId.get());
    repository.save(pets);
    return pets;
  }
 
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}