package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entitys.EmployeeInfo;
import com.example.demo.repositarys.EmployeeRepository;

@SpringBootApplication
public class CompletedTripServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompletedTripServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
//			@Autowired
//			BookingRequestRepositary repo;
//			@Autowired
//			TripCabInfoRepositary cabRepo;
//			@Autowired
//			DriverInfoRepositary driverRepo;
//			@Autowired
//			ComplaintsRepositary comRepo;
//			@Autowired
//			CompletedTripService service;	
			@Autowired
			EmployeeRepository repo;
			@Override
			public void run(String... args) throws Exception {
//
	
//				EmployeeInfo emp = new EmployeeInfo("2038", "jithu", "kumar928jeba@hotmail.com", 9799779789l, "Arvinth", "cab", "Rohit", 0, 0, null, null, null, null, null);
//				repo.save(emp);
//	//BookingRequest user8 = new BookingRequest(123, "2038", "jithu", "kumar928jeba@hotmail.com", "alpha city", "velchery", "kelambakkam", LocalTime.of(10, 30), 1038, LocalTime.now(), LocalTime.now(), "reached", null);
////				BookingRequest user9 = new BookingRequest(988, 2234, "Ranbeer", "Alpha City", "velachery", "naruto",
////						LocalTime.now(), 6, LocalTime.of(10, 0), LocalTime.now(), "Reached", null);
////				BookingRequest user10 = new BookingRequest(776, 6453, "harish", "Alpha City", "Guindy", "valasaravakkam",
////						LocalTime.now(), 8, LocalTime.of(10, 0), LocalTime.of(12, 0), "Ongoing", null);
//				//repo.save(user8);
////				repo.save(user9);
//////				repo.save(user10);
////		TripCabInfo trip4= new TripCabInfo(1038, "TN10DH2899", 1, "Alpha City", "saidapet", "anna nagar",
////					LocalDate.now(), LocalTime.now(), 7, 0, 7, "Reached", LocalTime.of(9, 0), LocalTime.of(10, 30));
//			//cabRepo.save(trip4);
////				DriverInfo ramesh = new DriverInfo(1, "Ramesh", 987675675, "kuma@ere", "TNxxxxxxx", LocalDate.now());
////				driverRepo.save(ramesh);
////
////				comRepo.save(new Complaints("Fast Driving"));
////				comRepo.save(new Complaints("Drink and Drive"));
////				comRepo.save(new Complaints("Cab is Not Clean"));
////				comRepo.save(new Complaints("Using Mobile While Driving"));
//				
		}
	};
}

}
