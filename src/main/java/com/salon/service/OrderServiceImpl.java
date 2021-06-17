package com.salon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.salon.bean.Order;
import com.salon.dao.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService
{
	
	@Autowired
	IOrderRepository orepo;
	
	@Override
	public Order addOrder(Order order) 
	{
		Order o1=orepo.save(order);
		return o1;
	}
	
	@Override
	public String removeOrder(long id) throws Exception 
	{
		Supplier<Exception> o2 = ()->new ResourceNotFoundException("Order id is not present in the database");
		Order e1=orepo.findById(id).orElseThrow(o2);
		orepo.deleteById(id);
	 return  "Deleted Successful";	
	}
	
	@Override
    public Order updateOrder(Order e) throws Exception  
	{
		long id=e.getOrderId();
		Supplier<Exception> o1 = ()->new ResourceNotFoundException("Order id is not present in the database");
		Order e1=orepo.findById(id).orElseThrow(o1);
		e1.setOrderId(e.getOrderId());
		  e1.setOrderAmount(e.getOrderAmount());
		  e1.setOrderbillingDate(e.getOrderbillingDate());
			orepo.save(e1);
			return e1;	
	}

	 @Override
	 public Order getOrderDetails(long id) throws Exception 
	 {
	    	Supplier<Exception> s2 = ()->new ResourceNotFoundException("Service id is not present in the database");
	    	Order o1=orepo.findById(id).orElseThrow(s2);
			return o1;	
	 }	

	
    @Override
	public List<Order> getAllOrders()
    {
		List<Order> ls=new ArrayList<>();
		ls=orepo.findAll();
		return ls;
	}
    
}


