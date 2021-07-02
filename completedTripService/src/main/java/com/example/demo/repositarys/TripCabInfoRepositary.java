package com.example.demo.repositarys;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entitys.TripCabInfo;

public interface TripCabInfoRepositary extends MongoRepository<TripCabInfo, Long> {
	TripCabInfo findRequestByTripCabID(long tripCabId);

}
