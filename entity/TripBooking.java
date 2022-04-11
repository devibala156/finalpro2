package com.abc.CabBookingApplication.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="trip_booking_table")
public class TripBooking{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tripBookingId;
	
	@Column(name="customer_id")
	private int customerId;
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;
	
	@Column(name="from_loc")
	private String fromLocation;
	
	@Column(name="to_loc")
	private String toLocation;
	
	@Column(name="from_date_time")
	private LocalDateTime fromDateTime;
	
	@Column(name="to_date_time")
	private LocalDateTime toDateTime;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="distance_in_km")
	private float distanceInKm;
	
	@Column(name="bill")
	private float bill;
	
	
	public int getTripBookingId() {
		return tripBookingId;
	}
	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public float getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
}
