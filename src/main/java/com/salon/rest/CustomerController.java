package com.salon.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.bean.Customer;
import com.salon.service.CustomerServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CustomerController 
{
	@Autowired
	CustomerServiceImpl customerservice;
	
	@PostMapping(path="/addCustomer")
	public Customer addCustomer(@Valid @RequestBody Customer customer )
	{
		 customerservice.addCustomer(customer);
		return customer;
	}
	
	@DeleteMapping(path="/removeCustomer/{userId}")
	public String removeCustomer(@PathVariable int userId) throws Exception
	{
		String s1 = customerservice.removeCustomer(userId);
				return s1;
    }

	@GetMapping(path="/getCustomer/{userId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int userId) throws Exception
	{
		Customer c1=customerservice.getCustomer(userId);
		
		ResponseEntity re=new ResponseEntity<Customer>(c1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer e) throws Exception
	{
		Customer e1=customerservice.updateCustomer(e);
		
		ResponseEntity re=new ResponseEntity<Customer>(e1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		List<Customer> le=customerservice.getAllCustomers();
		
		ResponseEntity re=new ResponseEntity<List<Customer>>(le,HttpStatus.OK);
		return re;
	}

}


