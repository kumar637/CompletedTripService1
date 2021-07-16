package com.example.demo.BO;

import java.time.LocalTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class TripSheetBO {
	String employeeId;
	String emlpoyeeName;
	String dropPoint;
	LocalTime reachedTime;
}
