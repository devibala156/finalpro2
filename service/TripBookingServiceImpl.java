package com.abc.CabBookingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.CabBookingApplication.Repository.TripBookingRepository;
import com.abc.CabBookingApplication.entity.TripBooking;
import com.abc.CabBookingApplication.exception.ResourceNotFoundException;

@Service
public class TripBookingServiceImpl implements TripBookingService{
	@Autowired
	private TripBookingRepository tripBookingRepository;
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		float bill=0.0f;
		bill=tripBooking.getDriver().getCab().getPerKmRate()*tripBooking.getDistanceInKm();
		tripBooking.setBill(bill);
		TripBooking newTrip = tripBookingRepository.save(tripBooking);
		return newTrip;
		//need to handle customer exception
	}
	

	@Override
	public List<TripBooking> getAllTrips() {
		List<TripBooking> trips=tripBookingRepository.findAll(); // gets all the details
		return trips;
	}
	@Override
	public TripBooking getTripById(int tripId) {
		Optional<TripBooking> optionalTrip=tripBookingRepository.findById(tripId);
		if(optionalTrip.isEmpty())
			throw new ResourceNotFoundException("Trip does not exist with TripId "+tripId);
		TripBooking trip=optionalTrip.get();
		return trip;
	}
	@Override
	public TripBooking UpdateTripBooking(TripBooking tripBooking) {
		//TripBooking trip=getTripById(tripBooking.getTripBookingId());
		Optional<TripBooking> optionalTrip=tripBookingRepository.findById(tripBooking.getTripBookingId());
		if(optionalTrip.isEmpty())
			throw new ResourceNotFoundException("Trip does not exist with TripId "+tripBooking.getTripBookingId());
		float bill=0.0f;
		bill=tripBooking.getDriver().getCab().getPerKmRate()*tripBooking.getDistanceInKm();
		tripBooking.setBill(bill);
		TripBooking newTrip=tripBookingRepository.save(tripBooking);
		return newTrip;
		
	}
	@Override
	public List<Float> customerBill(int customerId) {
		List<Float> bills=tripBookingRepository.getBillOfCustomer(customerId);
		return bills;
	}
}
