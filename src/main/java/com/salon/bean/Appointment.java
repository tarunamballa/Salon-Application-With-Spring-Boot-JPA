package com.salon.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Appointment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long appointmentId;
	@NotNull
	private String location;
	@NotNull
	private String visitType;
	@NotNull
	private String preferredService;
	@NotNull
	private String preferredDate;
	@NotNull
	private String preferredTime;
	@NotNull
	private String status;
	
	
	public long getAppointmentId() 
	{
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId)
	{
		this.appointmentId = appointmentId;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}
	public String getVisitType() 
	{
		return visitType;
	}
	public void setVisitType(String visitType) 
	{
		this.visitType = visitType;
	}
	public String getPreferredService()
	{
		return preferredService;
	}
	public void setPreferredService(String preferredService) 
	{
		this.preferredService = preferredService;
	}
	public String getPreferredDate() 
	{
		return preferredDate;
	}
	public void setPreferredDate(String preferredDate) 
	{
		this.preferredDate = preferredDate;
	}
	public String getPreferredTime() 
	{
		return preferredTime;
	}
	public void setPreferredTime(String preferredTime) 
	{
		this.preferredTime = preferredTime;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}


	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", location=" + location + ", visitType=" + visitType
				+ ", preferredService=" + preferredService + ", preferredDate=" + preferredDate + ", preferredTime="
				+ preferredTime + ", status=" + status + "]";
	}
	

}
