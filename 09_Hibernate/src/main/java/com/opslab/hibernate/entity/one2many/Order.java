package com.opslab.hibernate.entity.one2many;

public class Order {
	private Integer id;
	
	private String OrderId;
	
	private String OrderName;
	
	private Customer customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", OrderId=" + OrderId + ", OrderName=" + OrderName + ", customer=" + customer + "]";
	}
	
}
