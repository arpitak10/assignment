package com.gainsight.mvc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gainsight.mvc.dao.FlightDAO;
import com.gainsight.mvc.entity.Flight;

@Controller
public class SearchController {
	

	
	@Autowired
	FlightDAO flightdao;
	@GetMapping("/search")
	public String search(@RequestParam String src,@RequestParam String dest,Model model)
	{
		ArrayList<Flight> fl=null;
	fl=	flightdao.searchFlight(src, dest);
	model.addAttribute("fl", fl);
	return "Booking";
	
		
	}
 	}
 	

