package com.opslab.hibernate.test;


import com.opslab.hibernate.entity.one2many.Customer;
import com.opslab.hibernate.entity.one2many.Order;
import org.junit.Test;

import java.util.Iterator;

public class one2manyTest extends SuperTest{


	
	/**
	 *测试保存
	 */
	@Test
	public void testOne2manySave(){
		Customer customer1 = new Customer();
		customer1.setCustomerName("和尚");
		
		Order order1 = new Order();
		order1.setOrderId(String.valueOf(System.currentTimeMillis()));
		order1.setOrderName("袈裟");
		order1.setCustomer(customer1);
		
		Order order2 = new Order();
		order2.setOrderId(String.valueOf(System.currentTimeMillis()));
		order2.setOrderName("法杖");
		order2.setCustomer(customer1);	

		Order order3 = new Order();
		order3.setOrderId(String.valueOf(System.currentTimeMillis()));
		order3.setOrderName("佛珠");
		order3.setCustomer(customer1);	
		
		customer1.getOrderSet().add(order1);
		customer1.getOrderSet().add(order2);
		customer1.getOrderSet().add(order3);
		
		//对象持久化
		session.save(customer1);
		session.save(order1);
		session.save(order2);
		session.save(order3);
	}
	
	
	@Test
	public void testOne2manyLoad(){
		Customer customer1 = (Customer) session.load(Customer.class, 1);
		System.out.println(customer1);
		System.out.println(customer1.getOrderSet().size());
		Iterator<Order> iter = customer1.getOrderSet().iterator();
		while(iter.hasNext()){
			Order order = iter.next();
			System.out.println(order);
		}
	}
}
