package com.abc.CabBookingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.CabBookingApplication.entity.Cab;
import com.abc.CabBookingApplication.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("SELECT c FROM Cab c WHERE c.carType = :cartype")
	List<Cab> findByType(@Param("cartype") String carType);
}
