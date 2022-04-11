package com.abc.CabBookingApplication.service;

import java.util.List;

import com.abc.CabBookingApplication.entity.Driver;

public interface DriverService {
	public Driver insertDriver(Driver driver);
	public Driver updateDriver(Driver driver);
	public void deleteDriver(int driverId);
	public List<Driver> viewBestDrivers();
	public Driver viewDriver(int driverId);
}
