package com.abc.CabBookingApplication.service;

import java.time.LocalDateTime;
import java.util.List;

import com.abc.CabBookingApplication.entity.Admin;
import com.abc.CabBookingApplication.entity.TripBooking;

public interface AdminService {

	public Admin saveAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public void removeAdmin(int adminId);
	public List<TripBooking> allTrips (int customer_id);
	public List<TripBooking> allTripsCustomerWise();
	public List<TripBooking> allTripsDateWise();
	public List<TripBooking> tripsCabWise();
	public List<TripBooking> getAllTripsForDays(int custId,LocalDateTime fromDate,LocalDateTime toDate);
}
