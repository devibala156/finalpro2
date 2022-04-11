package com.abc.CabBookingApplication.payload;

import java.time.LocalDateTime;

public class TripRequest {
	private int customerId;
	private int driverId;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private int distanceInKm;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
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
	public int getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(int distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
}
