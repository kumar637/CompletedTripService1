package com.example.demo.repositarys;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entitys.EmployeeInfo;

public interface EmployeeRepository extends MongoRepository<EmployeeInfo, String> {

}
