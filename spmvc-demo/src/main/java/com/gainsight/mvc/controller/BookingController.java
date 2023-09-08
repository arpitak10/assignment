package com.gainsight.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gainsight.mvc.dao.BookingDAO;
import com.gainsight.mvc.dao.PassengerDAO;

@Controller
public class BookingController {
	
	@Autowired
	BookingDAO bdao;
	
	@Autowired
	PassengerDAO pdao;
	
	@GetMapping("/Booking")
	public String getLoginPage()
	{
		return "BookingForm";
	}
	
	@GetMapping("/bookingDetails")
	public String addDetails(@RequestParam String bookingId, @RequestParam String flightId, @RequestParam String passengerId,@RequestParam String firstName, @RequestParam String lastName ,@RequestParam Long mobile ,@RequestParam String email , @RequestParam String travelDate,Model model)
	{
		boolean c1=bdao.addBookingDetails(bookingId, flightId, passengerId, travelDate);
		boolean c2=pdao.addPassenegrDetails(passengerId, firstName, lastName, mobile, email);
		
		String message="Booking not added";
		if(c1 && c2) {
			model.addAttribute("message",message);
			message="Booking added successfully";
			return "SearchPnrForm";
		}
		
		model.addAttribute("message",message);
		return "Display";
	}
}