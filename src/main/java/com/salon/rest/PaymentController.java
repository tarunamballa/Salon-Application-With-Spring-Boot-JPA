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

import com.salon.bean.Payment;
import com.salon.service.IPaymentService;

@RestController
public class PaymentController 
{
	
	@Autowired
	IPaymentService paymentservice;
	
	@PostMapping(path="/addPayment")
	public Payment addPayment( @Valid  @RequestBody Payment payment) 
	{
		Payment p=paymentservice.addPayment(payment);
		return p;
	}
	
	@DeleteMapping(path="/removePayment/{id}")
	public String removePayment(@PathVariable Long id) throws Exception 
	{
		paymentservice.removePayment(id);
			return "errorrr";
	}
	
	@PutMapping(path="/updatePayment/{paymentId}")
	public ResponseEntity<Payment> updatePaymentById(@Valid @RequestBody Payment p)throws Exception 
	{
		Payment p1=paymentservice.updatePayment(p);
		ResponseEntity<Payment> re=new ResponseEntity<Payment>(p1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getPaymentDetails/{id}")
	public ResponseEntity<Payment> getPaymentDetails(@PathVariable long id) throws Exception
	{
	Payment p1=paymentservice.getPaymentDetails(id);
	ResponseEntity re=new ResponseEntity<Payment>(p1,HttpStatus.OK);
	return re;
	}
	
	@GetMapping(path="/getAllPaymentDetails")
	public ResponseEntity<List>getAllPaymentDetails()
	{
		List<Payment> p1=paymentservice.getAllPaymentDetails();
		ResponseEntity re=new ResponseEntity<List>(p1,HttpStatus.OK);
		return re;
	}

}
