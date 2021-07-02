package com.example.demo.repositarys;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entitys.Complaints;

public interface ComplaintsRepositary extends MongoRepository<Complaints ,Integer> {
	

}
