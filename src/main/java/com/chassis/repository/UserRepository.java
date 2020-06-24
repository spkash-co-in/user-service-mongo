package com.chassis.repository;

import com.chassis.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String>{
    @Query("{'fName': ?0}")
    User findByFName(String fName);
    @Query("{fName: ?0, lName: ?1}")
    User findByFNameAndLName(String fName, String lName);
}
