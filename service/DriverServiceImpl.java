package com.abc.CabBookingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.CabBookingApplication.Repository.DriverRepository;
import com.abc.CabBookingApplication.entity.Driver;
import com.abc.CabBookingApplication.exception.ResourceNotFoundException;

@Service
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	private DriverRepository driverRepository;
	@Override
	public Driver insertDriver(Driver driver) {
		Driver insertDriver=driverRepository.save(driver);
		return insertDriver;
	}

	@Override
	public Driver updateDriver(Driver driver) {
		Driver updateDriver = viewDriver(driver.getDriverId());
		updateDriver = driverRepository.save(driver);
		return updateDriver;
	}

	@Override
	public void deleteDriver(int driverId) {
		Driver driver = viewDriver(driverId);
		driverRepository.delete(driver);
	}

	@Override
	public List<Driver> viewBestDrivers() {
		List<Driver> drivers=driverRepository.findByRatingGreaterThan(4.5f);
		if(drivers.isEmpty())
			throw new ResourceNotFoundException("Best drivers not found");
		
		return drivers;
	}

	@Override
	public Driver viewDriver(int driverId) {
		Optional<Driver> optionalDriver = driverRepository.findById(driverId);
		if (optionalDriver.isEmpty())
			throw new ResourceNotFoundException("Driver Not found with id : " + driverId);
		Driver driver = optionalDriver.get();
		return driver;
	}
}
