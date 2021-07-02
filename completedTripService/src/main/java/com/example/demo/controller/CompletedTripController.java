package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BO.CompletedTripBO;
import com.example.demo.entitys.BookingRequest;
import com.example.demo.entitys.Complaints;
import com.example.demo.entitys.DriverInfo;
import com.example.demo.repositarys.BookingRequestRepositary;

import com.example.demo.services.CompletedTripService;

@RestController
@RequestMapping(path = "/api/v1")
public class CompletedTripController {

	@Autowired

	CompletedTripService service;
	@Autowired
	BookingRequestRepositary repo;

	@GetMapping(path = "/completedTrip/{tripCabId}")
	public ResponseEntity<CompletedTripBO> getCompletedTrip(@PathVariable("tripCabId") long tripCabId) {
		CompletedTripBO completedTrip = this.service.getCompletedTrip(tripCabId);
		return ResponseEntity.status(HttpStatus.OK).body(completedTrip);
	}

	@GetMapping(path = "/bookReq/{tripCabId}")
	public ResponseEntity<List<BookingRequest>> getBookingRequest(@PathVariable("tripCabId") long tripCabId) {
		List<BookingRequest> bookingRequest = this.service.getBookingRequest(tripCabId);
		return ResponseEntity.status(HttpStatus.OK).body(bookingRequest);
	}

	@GetMapping(path = "/driver/{driverId}")
	public ResponseEntity<DriverInfo> getDriverDetails(@PathVariable("driverId") long driverId) {
		DriverInfo info = this.service.getDriverDetails(driverId);
		return ResponseEntity.status(HttpStatus.OK).body(info);

	}

	@GetMapping(path = "/complaints")
	public ResponseEntity<List<Complaints>> getComplaints() {
		List<Complaints> complaints = this.service.getComplaints();
		return ResponseEntity.status(HttpStatus.OK).body(complaints);
	}



	@PutMapping(path = "/updateComplaints/{bookingId}/{complaint}")
	public ResponseEntity<BookingRequest> updateComplaints(@PathVariable("complaint") String complaintDes,
			@PathVariable("bookingId") long bookingId) {
		BookingRequest updateComplaints = this.repo.findByBookingId(bookingId);
		// update the complaint description in BookingRequestBO
		// get the complaints in DB
		String cmpDes = updateComplaints.getComplaintDescription();
		BookingRequest updatedComplaint = null;

		if (cmpDes == null) {
			// send mail to User ---> Admin or HR
			service.sendEmail();

			updateComplaints.setComplaintDescription(complaintDes);
			updatedComplaint = repo.save(updateComplaints);

		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(updatedComplaint);
	}
}
