package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entitys.BookingRequest;
import com.example.demo.entitys.Complaints;
import com.example.demo.entitys.DriverInfo;
import com.example.demo.entitys.TripCabInfo;
import com.example.demo.repositarys.BookingRequestRepositary;
import com.example.demo.repositarys.ComplaintsRepositary;
import com.example.demo.repositarys.DriverInfoRepositary;
import com.example.demo.repositarys.TripCabInfoRepositary;
import com.example.demo.services.CompletedTripService;

@SpringBootApplication
public class CompletedTripServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompletedTripServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			@Autowired
			BookingRequestRepositary repo;
			@Autowired
			TripCabInfoRepositary cabRepo;
			@Autowired
			DriverInfoRepositary driverRepo;
			@Autowired
			ComplaintsRepositary comRepo;
			@Autowired
			CompletedTripService service;

			@Override
			public void run(String... args) throws Exception {

				BookingRequest user1 = new BookingRequest(124, 2098, "kumar", "Alpha City", "Tamabaram", "AGS",
						LocalTime.now(), 6, LocalTime.of(9, 0), LocalTime.of(10, 0), "Reached", null);
				BookingRequest user2 = new BookingRequest(123, 2096, "jithu", "Alpha City", "velachery", "kelambakam",
						LocalTime.now(), 6, LocalTime.of(10, 0), LocalTime.of(11, 0), "Reached", null);
				BookingRequest user3 = new BookingRequest(125, 2094, "Ravi", "Alpha City", "Guindy", "Guindy",
						LocalTime.now(), 6, LocalTime.of(10, 0), LocalTime.of(11, 0), "Reached", "None");
			//	repo.save(user1);
				repo.save(user2);
			//	repo.save(user3);
	//			TripCabInfo trip1 = new TripCabInfo(6, "TN10Ay8434", 1, "Alpha City", "Tambaram", "AGS",
	//					LocalDate.now(), LocalTime.now(), 7, 0, 7, "Reached", LocalTime.of(9, 0), LocalTime.of(10, 30));
	//			cabRepo.save(trip1);
//				DriverInfo ramesh = new DriverInfo(1, "Ramesh", 987675675, "kuma@ere", "TNxxxxxxx", LocalDate.now());
//				driverRepo.save(ramesh);
//
//				comRepo.save(new Complaints("Fast Driving"));
//				comRepo.save(new Complaints("Drink and Drive"));
//				comRepo.save(new Complaints("Cab is Not Clean"));
//				comRepo.save(new Complaints("Using Mobile While Driving"));
				
				//service.sendEmail("jebakumar928@gmail", "you have notification", "Admin");

			}
	};
	}
	
			
				
}
	
