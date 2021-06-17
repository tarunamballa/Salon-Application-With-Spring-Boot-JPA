package com.salon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salon.bean.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long>{

}
