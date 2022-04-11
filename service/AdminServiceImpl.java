package com.abc.CabBookingApplication.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.CabBookingApplication.Repository.AdminRepository;
import com.abc.CabBookingApplication.Repository.TripBookingRepository;
import com.abc.CabBookingApplication.entity.Admin;
import com.abc.CabBookingApplication.entity.TripBooking;
import com.abc.CabBookingApplication.exception.ResourceNotFoundException;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private TripBookingRepository tripBookingRepository;

	@Override
	public Admin saveAdmin(Admin admin) {
	Admin savedAdmin=adminRepository.save(admin);
		return savedAdmin;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Optional<Admin> optionalAdmin=adminRepository.findById(admin.getAdminId());
		if(optionalAdmin.isEmpty())
		    throw new ResourceNotFoundException("admin not existing with id "+admin.getAdminId());
		Admin updatedAdmin=adminRepository.save(admin);
		return updatedAdmin;

	}

	@Override
	public void removeAdmin(int adminId) {
		Optional<Admin> optionalAdmin=adminRepository.findById(adminId);
		if(optionalAdmin.isEmpty())
			throw new ResourceNotFoundException("admin not existing with id "+adminId);
		Admin admin=optionalAdmin.get();
		adminRepository.delete(admin);
	}

	@Override
	public List<TripBooking> allTrips(int customer_id) {
		List<TripBooking> trips = tripBookingRepository.findAllByCustomerId(customer_id);
		return trips;
	}

	@Override
	public List<TripBooking> allTripsCustomerWise() {
		List<TripBooking> trips = tripBookingRepository.findByOrderByCustomerIdAsc();
		return trips;
	}

	@Override
	public List<TripBooking> tripsCabWise() {
		List<TripBooking> trips = tripBookingRepository.findByOrderByDriverAsc();
		return trips;
	}

	@Override
	public List<TripBooking> allTripsDateWise() {
		List<TripBooking> trips = tripBookingRepository.findByOrderByFromDateTimeAsc();
		return trips;
	}

	@Override
	public List<TripBooking> getAllTripsForDays(int custId, LocalDateTime fromDate, LocalDateTime toDate) {
		List<TripBooking> trips = tripBookingRepository.findAllWithFromDateTimeBefore(custId, fromDate, toDate);
		return trips;
	}
}
