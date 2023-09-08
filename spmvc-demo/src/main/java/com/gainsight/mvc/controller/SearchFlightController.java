package com.gainsight.mvc.controller;
import com.gainsight.mvc.dao.BookingDAO;
import com.gainsight.mvc.entity.Bookings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class SearchFlightController {
	
	@Autowired
	BookingDAO bookingDao;
	
	@GetMapping("/searchByPNR")
	public String getLoginPage()
	{
		return "SearchPnrForm";
	}
	
	@GetMapping("/showBookingDetails")
	public String displayBookedFlight(@RequestParam String bookingId,Model model)
	{
		
		Bookings b= bookingDao.display(bookingId);
		String message="Booking id:"+b.getBooking_id()+"/n"+"FlightId:/n"+b.getFlight_id()+"Passenegrid:/n"+b.getPassenger_id()+"TravelDate:"+b.getTravel_date();
		model.addAttribute("message",message);
		
		return "DisplayBookingDetails";
	}
	
}