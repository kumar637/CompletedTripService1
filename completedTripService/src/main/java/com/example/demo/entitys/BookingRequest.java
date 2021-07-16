package com.example.demo.entitys;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "bookingRequest")

public class BookingRequest {
	
	@Id
	long bookingId;
	String employeeId;
	String emlpoyeeName;
	String  source;
	String destination;
	String dropPoint;
	LocalTime timeSlot;
	int tripCabId;
	LocalTime startTime;
	LocalTime reachedTime;
	String status;
	String complaintDescription;
}
