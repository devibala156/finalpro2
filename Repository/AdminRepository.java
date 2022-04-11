package com.abc.CabBookingApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.CabBookingApplication.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
}
