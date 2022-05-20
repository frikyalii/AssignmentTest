package com.capgemini.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.model.Customer;

public interface customerRepository extends MongoRepository<Customer, Integer> {

}
