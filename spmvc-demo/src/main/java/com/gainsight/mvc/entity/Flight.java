package com.gainsight.mvc.entity;

public class Flight{
	private String flight_id;
	private String source;
	private String destination;
	private double fare;
	private int seats_available;
	public Flight() {}
	public Flight(String flight_id, String source, String destination, double fare, int seats_availale ) {
		
		this.flight_id = flight_id;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
		this.seats_available = seats_available;
	}
	public String getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public int getSeats_available() {
		return seats_available;
	}
	public void setSeats_available(int seats_available) {
		this.seats_available = seats_available;
	}
	
	

}
