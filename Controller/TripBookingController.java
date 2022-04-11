package com.abc.CabBookingApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.CabBookingApplication.entity.Driver;
import com.abc.CabBookingApplication.entity.TripBooking;
import com.abc.CabBookingApplication.payload.TripRequest;
import com.abc.CabBookingApplication.service.DriverService;
import com.abc.CabBookingApplication.service.TripBookingService;

@RestController
@RequestMapping("/trip")
public class TripBookingController {

	@Autowired
	private TripBookingService tripBookingService;
	
	@Autowired
	private DriverService driverService;
	
	@PostMapping("/save")
	public ResponseEntity<?> bookTrip(@RequestBody TripRequest tripRequest) {
	ResponseEntity<?> responseEntity=null;
	TripBooking tripBooking= new TripBooking();
	tripBooking.setCustomerId(tripRequest.getCustomerId());
	Driver driver=driverService.viewDriver(tripRequest.getDriverId());
	tripBooking.setDriver(driver);
	tripBooking.setFromLocation(tripRequest.getFromLocation());
	tripBooking.setToLocation(tripRequest.getToLocation());
	tripBooking.setFromDateTime(tripRequest.getFromDateTime());
	tripBooking.setToDateTime(tripRequest.getToDateTime());
	tripBooking.setStatus(true);
	tripBooking.setDistanceInKm(tripRequest.getDistanceInKm());
	tripBooking.setBill(0);
	TripBooking newTrip=tripBookingService.insertTripBooking(tripBooking);
	responseEntity=new ResponseEntity<>(newTrip,HttpStatus.CREATED);
	return responseEntity;
	}
	
	@GetMapping("/all")
	public List<TripBooking> fetchllTrips() {
		List<TripBooking> trips = tripBookingService.getAllTrips();
		return trips;
	}
	
	@PutMapping("/update/{tripId}")
    public ResponseEntity<?> UpdateTrip(@PathVariable("tripId") int tripId,@RequestBody TripRequest tripRequest) {
   		ResponseEntity<?> responseEntity=null;
   		TripBooking tripBooking= new TripBooking();
   		tripBooking.setTripBookingId(tripId);
   		tripBooking.setCustomerId(tripRequest.getCustomerId());
   		Driver driver=driverService.viewDriver(tripRequest.getDriverId());
   		tripBooking.setDriver(driver);
   		tripBooking.setFromLocation(tripRequest.getFromLocation());
   		tripBooking.setToLocation(tripRequest.getToLocation());
   		tripBooking.setFromDateTime(tripRequest.getFromDateTime());
   		tripBooking.setToDateTime(tripRequest.getToDateTime());
   		tripBooking.setStatus(true);
   		tripBooking.setDistanceInKm(tripRequest.getDistanceInKm());
   		tripBooking.setBill(0);
   		TripBooking newTrip=tripBookingService.UpdateTripBooking(tripBooking);
   		responseEntity=new ResponseEntity<>(newTrip,HttpStatus.CREATED);
   		return responseEntity;
   	    }
	
	@GetMapping("/getbill/{id}") // {id} to send the id;
 	public ResponseEntity<?> fetchCustomerById(@PathVariable("id") int customerId) {
 		ResponseEntity<?> responseEntity = null;
 		List<Float> bills = tripBookingService.customerBill(customerId);
 		responseEntity = new ResponseEntity<>(bills, HttpStatus.OK);
 		return responseEntity;
 	}
     @PutMapping("cancelTrip/{tripId}")
     public ResponseEntity<?> cancleTrip(@PathVariable("tripId")int tripId) {
  		ResponseEntity<?> responseEntity = null;
  		TripBooking tripBooking=tripBookingService.getTripById(tripId);
  		tripBooking.setStatus(false);
  		TripBooking newTrip=tripBookingService.insertTripBooking(tripBooking);
		responseEntity=new ResponseEntity<>(newTrip,HttpStatus.OK);
		return responseEntity;
     }
}