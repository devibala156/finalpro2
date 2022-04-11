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
import org.springframework.web.bind.annotation.RestController;

import com.abc.CabBookingApplication.entity.Customer;
import com.abc.CabBookingApplication.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/insert")
	public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer) {
		Customer insertCustomer = customerService.InsertCustomer(customer);
		ResponseEntity<Customer> responseEntity = null;
		responseEntity = new ResponseEntity<>(insertCustomer, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
		ResponseEntity<Object> responseEntity = null;
		
			Customer updateCustomer = customerService.updateCustomer(customer);
			responseEntity = new ResponseEntity<>(updateCustomer, HttpStatus.OK);
		
		return responseEntity;

   }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("id") int customerId) {
		ResponseEntity<Object> responseEntity = null;
		
			customerService.deleteCustomer(customerId);
			responseEntity = new ResponseEntity<>("Customer data deleted successfully", HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		return customerService.viewCustomers();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") int customerId) {
		ResponseEntity<Object> responseEntity = null;
		
			Customer customer = customerService.viewCustomer(customerId);
			responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);
		
		return responseEntity;
	}
}
