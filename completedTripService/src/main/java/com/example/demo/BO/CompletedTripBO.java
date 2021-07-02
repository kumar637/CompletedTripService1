package com.example.demo.BO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class CompletedTripBO {

	List<TripSheetBO> tripList; // list<kjbkbjy> bbj;
	String CabNumber;// date 
	String source;
	String destination;
	LocalTime timeSlot;
	LocalTime reachedTime;
	String driverName;
	long driverNumber;
	LocalDate dateOfTravel;
}
