package com.salon.service;

import java.util.List;
import java.util.Optional;

import com.salon.bean.Appointment;

public interface IAppointmentService 
{
	Appointment addAppointment(Appointment appointment);
	List<Appointment> getAllAppointments();
	List<Appointment> getAppointmentstatus(String status);
	String removeAppointment(Long id);
	Appointment updateAppointment(Appointment e) throws Exception;
	Optional<Appointment> getAppointment(Long id);

}
