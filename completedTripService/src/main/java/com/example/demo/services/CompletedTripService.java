package com.example.demo.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.BO.CompletedTripBO;
import com.example.demo.BO.TripSheetBO;
import com.example.demo.entitys.BookingRequest;
import com.example.demo.entitys.Complaints;
import com.example.demo.entitys.DriverInfo;
import com.example.demo.entitys.TripCabInfo;
import com.example.demo.repositarys.BookingRequestRepositary;
import com.example.demo.repositarys.ComplaintsRepositary;
import com.example.demo.repositarys.DriverInfoRepositary;
import com.example.demo.repositarys.TripCabInfoRepositary;

@Service(value = "completedTrip")
public class CompletedTripService {

	@Autowired
	BookingRequestRepositary repo;
	@Autowired
	TripCabInfoRepositary cabInfoRepo;
	@Autowired
	DriverInfoRepositary driverInfoRepo;
	@Autowired
	ComplaintsRepositary repositary;
	@Autowired
	JavaMailSender javaMailSender;

	public BookingRequest save(BookingRequest request) {
		return this.repo.save(request);
	}

	public CompletedTripBO getCompletedTrip(long tripCabId) {

			// get the tripCabId and fetch the details in it.
		TripCabInfo CompletedTrip = this.cabInfoRepo.findRequestByTripCabID(tripCabId);

			// get the details of bookingRequestBO through tripCabId
		List<BookingRequest> BookingDetails = this.repo.findByTripCabId(tripCabId);
		
		long driverID = CompletedTrip.getDriverID();

			// get the driver details through driverId
		DriverInfo info = this.driverInfoRepo.findByDriverId(driverID);

		CompletedTripBO cmptBo = new CompletedTripBO();
		List<TripSheetBO> tpList = new ArrayList<>();

			// set the required details to BO through the tripCabId and DriverId
		cmptBo.setDestination(CompletedTrip.getDestination());
		cmptBo.setDateOfTravel(CompletedTrip.getDateOfTravel());
		cmptBo.setTimeSlot(CompletedTrip.getTimeSlot());
		cmptBo.setDriverName(info.getDriverName());
		cmptBo.setDriverNumber(info.getDriverNumber());
		cmptBo.setSource(CompletedTrip.getSource());
		cmptBo.setCabNumber(CompletedTrip.getCabNumber());

			// for each employee
		for (BookingRequest eachRequest : BookingDetails) {
			tpList.add(new TripSheetBO(eachRequest.getEmployeeId(), eachRequest.getEmlpoyeeName(),
					eachRequest.getDropPoint(),eachRequest.getReachedTime()));
		}

		cmptBo.setTripList(tpList);
		

		return cmptBo;

	}

	public List<Complaints> getComplaints() { // get all complaints
		return this.repositary.findAll();
	}

	public BookingRequest updateComplaints(long bookingId, String complaintDescription) {
		return this.repo.findByBookingId(bookingId);// update the complaint description in BookingRequestBO
	}
	// Sent Email Service
	public SimpleMailMessage sendEmail() {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("kumar.v@avasoft.com");
		mail.setTo("kumar.v@avasoft.com");
		// mail.setTo("rohit.krish@hotmail.com");
		mail.setSubject("User");
		mail.setText("Hi there ");

		javaMailSender.send(mail);
		return mail;

	}

}
