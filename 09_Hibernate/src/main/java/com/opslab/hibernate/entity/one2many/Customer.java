package com.opslab.hibernate.entity.one2many;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	
	private Integer CustomerId;
	
	private String CustomerName;

	private Set<Order> orderSet = new HashSet<Order>();
	
	
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

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", CustomerName=" + CustomerName + "]";
	}
	
}
