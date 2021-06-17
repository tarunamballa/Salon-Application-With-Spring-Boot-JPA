package com.salon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salon.bean.Order;


public interface IOrderRepository extends JpaRepository<Order,Long>
{
	

}
