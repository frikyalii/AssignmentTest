package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.EmployeeModel;


public interface EmpProfileRepository extends MongoRepository<EmployeeModel, Integer> {

}
