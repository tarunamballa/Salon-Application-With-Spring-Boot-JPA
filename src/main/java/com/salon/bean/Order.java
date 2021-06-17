package com.salon.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Orders")
public class Order 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderId;
	
	@NotNull
	private double orderAmount;
	
	@NotNull
	private String orderbillingDate;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderbillingDate() {
		return orderbillingDate;
	}
	public void setOrderbillingDate(String orderbillingDate) {
		this.orderbillingDate = orderbillingDate;
	}
	@Override
	public String toString() 
	{
		return "Order [orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderbillingDate=" + orderbillingDate
				+ "]";
	}
}
