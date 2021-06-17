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

import com.salon.bean.Order;
import com.salon.dao.IOrderRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderServiceImplTest 
{
	@Autowired
	IOrderService iorderservice;
	@MockBean
	IOrderRepository orepo;
	@Test
	void testAddService() {
		Order order=new Order();
		order.setOrderId(1);
		order.setOrderAmount(100);
		order.setOrderbillingDate("12345678");
		Mockito.when(orepo.save(order)).thenReturn(order);	
		Order response=iorderservice.addOrder(order);
		assertThat(response.getOrderId()).isEqualTo(1);
		assertThat(response.getOrderAmount()).isEqualTo(100);
		assertThat(response.getOrderbillingDate()).isEqualTo("12345678");
			}
	@Test
	void testRemoveService() throws Exception {
		Order o1=new Order();
		o1.setOrderId(1);
		o1.setOrderAmount(100);
		o1.setOrderbillingDate("12345678");
		Optional<Order> o2=Optional.of(o1);
		Mockito.when(orepo.findById((long) 1)).thenReturn(o2);
		Mockito.when(orepo.existsById(o1.getOrderId())).thenReturn(false);
		assertFalse(orepo.existsById(o1.getOrderId()));	
	}
	@Test
	void testUpdateService() throws Exception {
		Order o1=new Order();
		o1.setOrderId(1);
		o1.setOrderAmount(100);
		o1.setOrderbillingDate("12345678");
		Optional<Order> o2=Optional.of(o1);
		Mockito.when(orepo.findById((long) 1)).thenReturn(o2);
		o1.setOrderAmount(50);
		Mockito.when(orepo.save(o1)).thenReturn(o1);
		assertThat(iorderservice.updateOrder(o1)).isEqualTo(o1);	
	}
	@Test
	void testGetOrderDetails() throws Exception {
		Order o1=new Order();
		o1.setOrderId(1);
		o1.setOrderAmount(100);
		o1.setOrderbillingDate("12345678");
		Optional<Order> o2=Optional.of(o1);
		Mockito.when(orepo.findById((long) 1)).thenReturn(o2);
		Optional<Order> o3=Optional.of(iorderservice.getOrderDetails(1));
		assertThat(o3).isEqualTo(o2);	
		
	}
       @Test
		void testGetAllOrders() {
		Order o1=new Order();
		o1.setOrderId(1);
		o1.setOrderAmount(100);
		o1.setOrderbillingDate("12345678");
		List<Order> ls=new ArrayList<>();
		ls.add(o1);
		Mockito.when(orepo.findAll()).thenReturn(ls);
		assertThat(iorderservice.getAllOrders()).isEqualTo(ls);		
	}

	

}
