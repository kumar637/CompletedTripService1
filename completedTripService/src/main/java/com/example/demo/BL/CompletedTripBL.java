package com.example.demo.BL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.example.demo.BO.CompletedTripBO;
import com.example.demo.entitys.BookingRequest;
import com.example.demo.entitys.Complaints;
import com.example.demo.services.CompletedTripService;

@Component
public class CompletedTripBL {

	@Autowired
	CompletedTripService service;

	public CompletedTripBO getCompletedTrip(long tripCabId) {
		return this.service.getCompletedTrip(tripCabId);

	}

	public List<Complaints> getComplaints() {
		return this.service.getComplaints();
	}

	public BookingRequest updateComplaints(long bookingId, String complaintDes) {
		return this.service.updateComplaints(bookingId, complaintDes);
	}

	public SimpleMailMessage sendEmail(long bookId,String complainDes) {
		return this.service.sendEmail(bookId, complainDes);

	}
}
