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
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salon.bean.Order;
import com.salon.service.OrderServiceImpl;

@RestController
public class OrderController
{
	@Autowired
	OrderServiceImpl orderservice;
	
	@PostMapping(path="/addOrder")
	public ResponseEntity<Order> addService(@Valid @RequestBody Order order)
	{
	 		Order o1=orderservice.addOrder(order);	
			ResponseEntity re=new ResponseEntity<Order>(o1,HttpStatus.OK);
			return re;
			}
	
	@DeleteMapping(path="/removeOrder/{id}")
	public ResponseEntity<String> removeOrder(@PathVariable Long id) throws Exception
	{
		 orderservice.removeOrder(id);	
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
			return re;
	}
	
	
	@GetMapping(path="/getAllOrders")
	public ResponseEntity<Order> getAllOrders()
	{
		List<Order> ls=orderservice.getAllOrders();
		ResponseEntity re=new ResponseEntity<List<Order>>(ls,HttpStatus.OK);
		return re;		
	}
	
	@PutMapping(path="/updateOrder")
	public ResponseEntity<Order> updateOrder(@Valid @RequestBody Order order) throws Exception
	{
		Order e1= orderservice.updateOrder(order);
		ResponseEntity re=new ResponseEntity<Order>(e1,HttpStatus.OK);
		return re;	
	}

	
	@GetMapping(path="/getOrderDetails/{id}") 
	public ResponseEntity<Order> getOrderDetails(@PathVariable Long id) throws Exception
	{
		Order o1=orderservice.getOrderDetails(id);
		
		ResponseEntity re=new ResponseEntity<Order>(o1,HttpStatus.OK);
		return re;	
	}
	
	
}
