package com.example.demo.repositarys;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entitys.BookingRequest;

public interface BookingRequestRepositary extends MongoRepository<BookingRequest, Long> {
	 List<BookingRequest> findByTripCabId(long tripCabId);
	 BookingRequest findByBookingId(long bookingId);
	 
}
