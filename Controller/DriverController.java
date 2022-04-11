package com.abc.CabBookingApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.CabBookingApplication.entity.Driver;
import com.abc.CabBookingApplication.service.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	
	
	@PostMapping("/insert")
	public ResponseEntity<Driver> insertDriver(@RequestBody Driver driver) {
		Driver insertDriver = driverService.insertDriver(driver);
		ResponseEntity<Driver> responseEntity = null;
		responseEntity = new ResponseEntity<>(insertDriver, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateDriver(@RequestBody Driver driver) {
		ResponseEntity<Object> responseEntity = null;
		
			Driver updateDriver = driverService.updateDriver(driver);
			responseEntity = new ResponseEntity<>(updateDriver, HttpStatus.OK);
		
		return responseEntity;

   }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDriverById(@PathVariable("id") int driverId) {
		ResponseEntity<Object> responseEntity = null;
		
			driverService.deleteDriver(driverId);
			responseEntity = new ResponseEntity<>("Driver data deleted successfully", HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getDriverById(@PathVariable("id") int driverId) {
		ResponseEntity<Object> responseEntity = null;
		
			Driver driver = driverService.viewDriver(driverId);
			responseEntity = new ResponseEntity<>(driver, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping("/getBestDrivers")
	public ResponseEntity<?> getDriverByRating() {
		ResponseEntity<Object> responseEntity = null;
		
			List<Driver> drivers = driverService.viewBestDrivers();
			responseEntity = new ResponseEntity<>(drivers, HttpStatus.OK);
		
		return responseEntity;
	}
	

}