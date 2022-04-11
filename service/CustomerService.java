package com.abc.CabBookingApplication.service;

import java.util.List;

import com.abc.CabBookingApplication.entity.Customer;

public interface CustomerService {
	public Customer InsertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(int customerId);
	public List<Customer> viewCustomers();
	public Customer viewCustomer(int customerId);
	//validate todo
}
