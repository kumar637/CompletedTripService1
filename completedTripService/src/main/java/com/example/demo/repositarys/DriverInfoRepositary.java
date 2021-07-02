package com.example.demo.repositarys;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entitys.DriverInfo;

public interface DriverInfoRepositary extends MongoRepository<DriverInfo, Long> {
	DriverInfo findByDriverId(long driverId);

}
