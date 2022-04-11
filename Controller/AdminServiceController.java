package com.abc.CabBookingApplication.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.abc.CabBookingApplication.entity.Admin;
import com.abc.CabBookingApplication.entity.TripBooking;
import com.abc.CabBookingApplication.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminServiceController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/insert") // to add a product
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) 
	{
		Admin newAdmin = adminService.saveAdmin(admin);
		ResponseEntity<Admin> responseEntity = new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateCustomer(@RequestBody Admin admin) {
		ResponseEntity<Object> responseEntity = null;
		Admin updatedAdmin = adminService.updateAdmin(admin);
		responseEntity = new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
		return responseEntity;

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAdminById(@PathVariable("id") int adminId) {
		ResponseEntity<?> responseEntity = null;
		adminService.removeAdmin(adminId);
		responseEntity = new ResponseEntity<>("admin deleted successfully", HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("/alltrips/{cid}")
	public List<TripBooking> fetchAllTrips(@PathVariable("cid") int customer_id) {
		List<TripBooking> trips = adminService.allTrips(customer_id);
		return trips;
	}
	
	@GetMapping("/allTripsCustomerWise")
	public List<TripBooking> fetchAllTripsCustomerWise() {
		List<TripBooking> trips = adminService.allTripsCustomerWise();
		return trips;
	}
	
	@GetMapping("/allTripsDateWise")
	public List<TripBooking> fetchAllTripsDateWise() {
		List<TripBooking> trips = adminService.allTripsDateWise();
		return trips;
	}
	
	@GetMapping("/alltripsbycab")
	public List<TripBooking> fetchAllCabWise() {
		List<TripBooking> trips = adminService.tripsCabWise();
		return trips;
	}
	
	@GetMapping("/allTripsForDays/{cid}/{fromDate}/{toDate}")
	public List<TripBooking> fetchAllTripsForDays(@PathVariable("cid") int customer_id,@PathVariable("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fromdate,@PathVariable("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime todate) {
		List<TripBooking> trips = adminService.getAllTripsForDays(customer_id, fromdate, todate);
		return trips;
	}
}