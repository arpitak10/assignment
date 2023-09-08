package com.gainsight.mvc.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gainsight.mvc.dao.FlightDAO;
import com.gainsight.mvc.dao.UserDAO;
import com.gainsight.mvc.entity.Flight;
import com.gainsight.mvc.entity.User;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
@Controller
public class LoginController {
	
	@Autowired 
	UserDAO udao;

	@Autowired
	FlightDAO fdao;

	@GetMapping("/loginPage")
	public String getLoginPage() {
		return "Login";
	}
	/*
	@PostMapping("/validateUser")
	public String authenticateUser(@RequestParam("uname")String username,@RequestParam("pword")String password,Model model)
	
	{   String message = "Invalid username or password";
		User user = new User(username,password);
	
	
		if(udao.validateUser(user)) {
			//message = "Welcome the the world of Java";
			
			return "Services";
			
		}
			
		model.addAttribute("message",message);
		
		return "Display";
	}
	*/
	//creating a cookies
	
	@PostMapping("/validateUser")
	public String authenticateUser(@RequestParam("uname")String username,@RequestParam("pword")String password,Model model,HttpServletResponse response)
	
	{   String message = "Invalid username or password";
		User user = new User(username,password);
	
	
		if(udao.validateUser(user)) {
			//message = "Welcome the the world of Java";
			Cookie c = new Cookie("username",username);
			response.addCookie(c);
			return "SearchFlight";
			
		}
			
		model.addAttribute("message",message);
		
		return "Display";
	}
	/*

	@PostMapping("/validateUser")
	public String authenticateUser(@RequestParam("uname")String username,@RequestParam("pword")String password,Model model)
	{   
		String message = "Invalid username or password";
		User user = new User(username,password);
	
	
		if(udao.validateUser(user)) {
			//message = "Welcome the the world of Java";
			
			return "SearchFlight";
			
		}
			
		model.addAttribute("message",message);
		return "Display";


	}
	*/

		

}

