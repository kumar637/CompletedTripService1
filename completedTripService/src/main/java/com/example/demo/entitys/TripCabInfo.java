package com.example.demo.entitys;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "tripCabInfo")
public class TripCabInfo {
	@Id
	long tripCabID;
	String cabNumber;
	long driverID;
	String source;
	String destination;
	String dropPoint;
	LocalDate dateOfTravel;
	LocalTime timeSlot;
	int totalSeats;	
	int remainingSeats;
	int allocatedSeats;
	String status;
	LocalTime startTime;
	LocalTime endTime;

}
