package com.salon.service;

import java.util.List;

import com.salon.bean.Customer;

public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);
	public String removeCustomer(long custId) throws Exception ;
	public Customer updateCustomer(Customer c) throws Exception;
	public Customer getCustomer(long custId) throws Exception;
	public List<Customer> getAllCustomers(); 

}
