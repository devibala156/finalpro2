package com.abc.CabBookingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.CabBookingApplication.Repository.CustomerRepository;
import com.abc.CabBookingApplication.entity.Customer;
import com.abc.CabBookingApplication.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer InsertCustomer(Customer customer) {
		Customer insertCustomer = customerRepository.save(customer);
		return insertCustomer;
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer updateCustomer = viewCustomer(customer.getCustomerId());
		updateCustomer = customerRepository.save(customer);
		return updateCustomer;
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		Customer customer = viewCustomer(customerId);
		customerRepository.delete(customer);
		
	}

	@Override
	public List<Customer> viewCustomers() {
		List<Customer> customers = customerRepository.findAll();
		if(customers.isEmpty())
			throw new ResourceNotFoundException("Customers not found");
		return customers;
		
	}

	@Override
	public Customer viewCustomer(int customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isEmpty())
			throw new ResourceNotFoundException("Customer Not found with id : " + customerId);
		Customer customer = optionalCustomer.get();
		return customer;
	
	}

}
