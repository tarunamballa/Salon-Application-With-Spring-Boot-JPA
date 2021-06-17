package com.salon.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Customer_Address")
public class Address
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long aId;
	
	@NotNull
	@Column(name="Door_No")
	private int doorNo;
	@NotNull
	@Column(name="Street_Name")
	private String street;
	@NotNull
	@Column(name="Area_Name")
	private String area;
	@NotNull
	@Column(name="City")
	private String city;
	@NotNull
	@Column(name="State")
	private String state;
	
	public Address() {
		
	}
	
	public Address(@NotNull int doorNo, @NotNull String street, @NotNull String area, @NotNull String city, @NotNull String state) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
	}
	
	public int getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + "]";
	}
	
}
