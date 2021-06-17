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
import org.springframework.web.bind.annotation.RestController;

import com.salon.bean.SalonService;
import com.salon.service.SalonServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class SalonServiceController 
{
	@Autowired
	SalonServiceImpl salonservice;
	@PostMapping(path="/addService")
	public ResponseEntity<SalonService> addService(@Valid @RequestBody SalonService salonService)
	{
		SalonService s1=salonservice.addService(salonService);	
		ResponseEntity re=new ResponseEntity<SalonService>(s1,HttpStatus.OK);
			return re;
			}
	@DeleteMapping(path="/removeService/{id}") 
	public ResponseEntity<String> removeService(@PathVariable Long id) throws Exception
	{
		 salonservice.removeService(id);	
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
			return re;
	}
	
	@GetMapping(path="/getService/{id}") 
	public ResponseEntity<SalonService> getService(@PathVariable Long id) throws Exception
	{
		SalonService s1=salonservice.getService(id);
		
		ResponseEntity re=new ResponseEntity<SalonService>(s1,HttpStatus.OK);
		return re;	
	}
	@GetMapping(path="/getAllServices")
	public ResponseEntity<SalonService> getAllServices()
	{
		List<SalonService> ls=salonservice.getAllServices();
		ResponseEntity re=new ResponseEntity<List<SalonService>>(ls,HttpStatus.OK);
		return re;		
	}
	@PutMapping(path="/updateService")
	public ResponseEntity<SalonService> updateService(@RequestBody SalonService salonService) throws Exception
	{
		SalonService s1= salonservice.updateService(salonService);
		ResponseEntity re=new ResponseEntity<SalonService>(s1,HttpStatus.OK);
		return re;	
	}
	@GetMapping(path="/getServiceByName")
	public ResponseEntity<List<SalonService>> getServiceByName(@RequestBody String ServiceName)
	{
		List<SalonService> l=salonservice.getServiceByName(ServiceName);	
		ResponseEntity re=new ResponseEntity<List<SalonService>>(l,HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/getServiceByPrice")
	public ResponseEntity<List<SalonService>> getServiceByPrice(@RequestBody double servicePrice)
	{
		List<SalonService> l=salonservice.getServiceByPrice(servicePrice);	
		ResponseEntity re=new ResponseEntity<List<SalonService>>(l,HttpStatus.OK);
		return re;	
	}
	@GetMapping(path="/getServiceByDuration")
	public ResponseEntity<List<SalonService>> getServiceByDuration(@RequestBody String serviceDuration)
	{
		List<SalonService> l= salonservice.getServiceDuration(serviceDuration);
		ResponseEntity re=new ResponseEntity<List<SalonService>>(l,HttpStatus.OK);
		return re;
	}
}