package com.example.mongorepo.optionalfails;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestDataWithOptionalRepository extends MongoRepository<TestDataWithOptional, String> {

}
