package com.capgemini.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.capgemini.model.Users;

public interface UserRepositiory extends MongoRepository<Users, String> {
	Users findByuserName(String userName);
}
