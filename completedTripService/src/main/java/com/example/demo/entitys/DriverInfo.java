package com.example.demo.entitys;

import java.time.LocalDate;

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
@Document(collection = "driverInfo")
public class DriverInfo {

	@Id
	long driverId;
	String driverName;
	long driverNumber;
	String password;
	String licenseNumber;
	LocalDate expiryDate;

}
