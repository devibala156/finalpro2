package com.abc.CabBookingApplication.service;

import java.util.List;

import com.abc.CabBookingApplication.entity.TripBooking;

public interface TripBookingService {
	public TripBooking insertTripBooking(TripBooking tripBooking);
	public List<TripBooking> getAllTrips();
	public TripBooking getTripById(int tripId);
	public TripBooking UpdateTripBooking(TripBooking tripBooking);
	public List<Float> customerBill(int customerId);
}
