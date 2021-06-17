package com.salon.service;

import java.util.List;

import com.salon.bean.Order;

public interface IOrderService 
{
	Order addOrder(Order order);

	String removeOrder(long id) throws Exception;

	Order updateOrder(Order e) throws Exception;
	
	Order getOrderDetails(long id) throws Exception;
	
	List<Order> getAllOrders();
	
}
