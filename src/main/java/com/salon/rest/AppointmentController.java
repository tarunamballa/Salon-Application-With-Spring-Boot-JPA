package com.salon.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salon.bean.Appointment;
import com.salon.service.AppointmentServiceImpl;


@RestController
public class AppointmentController 
{
	@Autowired
	AppointmentServiceImpl appointmentService;
	
	@PostMapping(path="/addAppointment")
	public ResponseEntity<Appointment> addAppointment(@Valid @RequestBody Appointment appointment)
	{
		Appointment a1=appointmentService.addAppointment(appointment);	
		ResponseEntity re=new ResponseEntity<Appointment>(a1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/removeAppointment/{id}")
	public ResponseEntity<String> removeAppointment(@PathVariable Long id)
	{
		appointmentService.removeAppointment(id);	
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}	
	
	@GetMapping(path="/getAppointment/{id}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable Long id)
	{
		Optional<Appointment> a1=appointmentService.getAppointment(id);
		ResponseEntity re=new ResponseEntity <Optional<Appointment>>(a1,HttpStatus.OK);
		return re;	
	}	
	
	@GetMapping(path="/getAllAppointments")
	public ResponseEntity<Appointment> getAllAppointments()
	{
		List<Appointment> ls=appointmentService.getAllAppointments();
		ResponseEntity re=new ResponseEntity<List<Appointment>>(ls,HttpStatus.OK);
		return re;	
	}
	
	@PostMapping(path="/updateAppointment") 
	public ResponseEntity<Appointment> updateAppointment(@Valid @RequestBody Appointment appointment) throws Exception
	{
		Appointment s1= appointmentService.updateAppointment(appointment);
		ResponseEntity<Appointment> re=new ResponseEntity<Appointment>(s1,HttpStatus.OK);
		return re;	
	}
	
	@GetMapping(path="/getAppointmentstatus")
	public ResponseEntity<List<Appointment>> getAppointmentstatus(@RequestBody String status)
	{
		List<Appointment> l=appointmentService.getAppointmentstatus(status);	
		ResponseEntity<List<Appointment>> re=new ResponseEntity<List<Appointment>>(l,HttpStatus.OK);
		return re;
	}
	
}
