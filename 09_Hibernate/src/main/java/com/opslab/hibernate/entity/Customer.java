package com.opslab.hibernate.entity;

public class Customer {
	
	private Integer CustomerId;
	
	private String CustomerName;


	public Integer getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Integer customerId) {
		CustomerId = customerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", CustomerName=" + CustomerName + "]";
	}
	
}
