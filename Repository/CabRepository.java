package com.abc.CabBookingApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.CabBookingApplication.entity.Cab;

public interface CabRepository extends JpaRepository<Cab,Integer>{
	@Query("SELECT c FROM Cab c WHERE c.carType = :cartype")
	List<Cab> findByType(@Param("cartype") String carType);
}
