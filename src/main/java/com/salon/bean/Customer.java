package com.salon.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	
	@NotNull
	@Size(min=6,message="User name should atleast 6 characters")
	@Column(name="User_name",nullable=false)
	private String name;
	
	@NotNull
	@Column(name="email",unique=true)
	@Email
	private String email;
	
	@NotNull
	@Size(min=10,max=10,message="Please provide valid mobile no.")
	private String contactNo;
	
	@NotNull
	private String dob;
	
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	public Customer() {
		
	}

	public Customer(@NotNull @Size(min = 6, message = "User name should atleast 6 characters") String name,
			@NotNull @Email String email,
			@NotNull @Size(min = 10, max = 10, message = "Please provide valid mobile no.") String contactNo,
			@NotNull String dob, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + "]";
	}
}
