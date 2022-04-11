package com.abc.CabBookingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.CabBookingApplication.entity.Driver;
import com.abc.CabBookingApplication.entity.TripBooking;

public interface DriverRepository extends JpaRepository<Driver, Integer>{
	@Query("SELECT d FROM Driver d WHERE d.rating >= :dRating")
	List<Driver> findByRatingGreaterThan(@Param("dRating") float rating);
}
