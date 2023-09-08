package com.gainsight.mvc.entity;

public class Bookings {
	private String booking_id;
	private String flight_id;
	private String passenger_id;
	private String travel_date;
	public Bookings() {}
	public String getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}
	public String getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}
	public String getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(String passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getTravel_date() {
		return travel_date;
	}
	public void setTravel_date(String travel_date) {
		this.travel_date = travel_date;
	}
	public Bookings(String booking_id, String flight_id, String passenger_id, String travel_date) {
		
		this.booking_id = booking_id;
		this.flight_id = flight_id;
		this.passenger_id = passenger_id;
		this.travel_date = travel_date;
	}
	
	

}
