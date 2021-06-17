package com.salon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salon.bean.Payment;

public interface IPaymentRepository extends JpaRepository<Payment,Long>{

}
