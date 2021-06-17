package com.salon.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.salon.bean.Address;
import com.salon.bean.Customer;
import com.salon.dao.ICustomerRepository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerServiceImplTest 
{
	@Autowired
	ICustomerService icustomerservice;
	
	@MockBean
	ICustomerRepository crepo;

	@Test
	void testAddCustomer() {
		Address address = new Address();
		address.setArea("Karimnagar");
		
		Customer customer = new Customer();
		customer.setUserId(1);
		customer.setName("Raviteja");
		customer.setEmail("Raviteja092.rt@gmail.com");
		customer.setDob("04-08-1998");
		customer.setAddress(address);
		
		Mockito.when(crepo.save(customer)).thenReturn(customer);
		Customer response = icustomerservice.addCustomer(customer);
		assertThat(response.getUserId()).isEqualTo(customer.getUserId());
		assertThat(response.getName()).isEqualTo(customer.getName());
		assertThat(response.getAddress().getArea()).isEqualTo(address.getArea());
		
	}

	@Test
	void testRemoveCustomer() throws Exception {
		Customer c1 = new Customer();
		c1.setUserId(1);
		c1.setName("ravi");
		c1.setEmail("Ravi@gmail.com");
		Optional<Customer> c2 = Optional.of(c1);
		Mockito.when(crepo.findById((long)1)).thenReturn(c2);
		Mockito.when(crepo.existsById(c1.getUserId())).thenReturn(false);
		assertFalse(crepo.existsById(c1.getUserId()));		
	}

	@Test
	void testGetCustomer() throws Exception 
	{
		Customer c1 = new Customer();
		c1.setUserId(1);
		c1.setName("ravi");
		c1.setEmail("Ravi@gmail.com");
		Optional<Customer> c2 = Optional.of(c1);
		Mockito.when(crepo.findById((long)1)).thenReturn(c2);
		Optional<Customer> c3 = Optional.of(icustomerservice.getCustomer(1));
		assertThat(c3).isEqualTo(c2);	
	}

	@Test
	void testUpdateCustomer() throws Exception 
	{
		Customer c1=new Customer();
		c1.setUserId(1);
		c1.setName("ravi");
		c1.setEmail("a@gmail.com");
		Optional<Customer> c2=Optional.of(c1);
		Mockito.when(crepo.findById((long) 1)).thenReturn(c2);
		c1.setName("raviteja");
		Mockito.when(crepo.save(c1)).thenReturn(c1);
		assertThat(icustomerservice.updateCustomer(c1)).isEqualTo(c1);
	}

	@Test
	void testGetAllCustomers() 
	{
		Customer c1 = new Customer();
		c1.setUserId(1);
		c1.setName("Ravi");
		List<Customer> ls = new ArrayList<>();
		ls.add(c1);
		Mockito.when(crepo.findAll()).thenReturn(ls);
		assertThat(icustomerservice.getAllCustomers()).isEqualTo(ls);
	}
	
}
