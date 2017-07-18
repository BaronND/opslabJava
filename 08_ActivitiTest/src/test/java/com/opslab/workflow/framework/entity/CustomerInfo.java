package com.opslab.workflow.framework.entity;

import java.io.Serializable;

public class CustomerInfo implements Serializable{

	private static final long serialVersionUID = 3522606042820464625L;

	private String customerId;
	
	private String customerName;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public CustomerInfo(String customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public CustomerInfo() {
		super();
	}
	
	
}
