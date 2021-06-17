package com.salon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.salon.bean.Customer;
import com.salon.dao.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService 
{
		@Autowired(required=true)
		ICustomerRepository crepo;
		
		List<Customer> le;
		
		@Override
		public Customer addCustomer(Customer customer) 
		{
			Customer c1 = crepo.save(customer);
			return c1;
		}
		
		@Override
		public String removeCustomer(long userId) throws Exception 
		{
			Supplier<Exception> s1 = ()->new ResourceNotFoundException(" id is not present in the database");
			crepo.findById(userId).orElseThrow(s1);
			crepo.deleteById(userId);
			return "Deleted";
		}
		
		
			
		@Override
		public Customer getCustomer(long userId) throws Exception 
		{
			Supplier<Exception> s1 = ()->new ResourceNotFoundException(" id is not present in the database");
			Customer c1=crepo.findById(userId).orElseThrow(s1);
			return c1;	
		}
		
		@Override
		public Customer updateCustomer(Customer c) throws Exception  
		{
			long id=c.getUserId();
			
			Supplier<Exception> s1 = ()->new ResourceNotFoundException(" id is not present in the database");
			Customer c1=crepo.findById(id).orElseThrow(s1);
			
			c1.setName(c.getName());
			c1.setContactNo(c.getContactNo());
			c1.setDob(c.getDob());
			c1.setEmail(c.getEmail());
			c1.setAddress(c.getAddress());
				
				crepo.save(c1);
				return c1;	
		}
		
		@Override
		public List<Customer> getAllCustomers()
		{
			le=new ArrayList<>();
			le=crepo.findAll();
			return le;
		}
		
}


