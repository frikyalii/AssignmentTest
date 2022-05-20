package com.capgemini.services;

import java.util.List;

import com.capgemini.model.Customer;

public interface customerService {

	public Customer addCustomer(Customer customer);

	public List getAllCustomer();

	public void deleteCustomer(int accountNumber);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer deposite(int deposite);

	public Customer withdraw(int withdraw);


}
