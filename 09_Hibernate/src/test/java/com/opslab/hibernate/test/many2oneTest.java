package com.opslab.hibernate.test;


import com.opslab.hibernate.entity.Customer;
import com.opslab.hibernate.entity.Order;
import org.junit.Test;

/**
 * 
 * @resume:测试多对一关系
 */
public class many2oneTest extends SuperTest{


	/**
	 *测试保存
	 */
	@Test
	public void testMany2oneSave(){
		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		
		customer1.setCustomerName("和尚");
		customer2.setCustomerName("尼姑");
		
		Order order1 = new Order();
		Order order2 = new Order();
		
		order1.setOrderId(String.valueOf(System.currentTimeMillis()));
		order1.setOrderName("order1");
		order1.setCustomer(customer1);
		
		order2.setOrderId(String.valueOf(System.currentTimeMillis()));
		order2.setOrderName("order2");
		order2.setCustomer(customer2);
		
		//保存到数据库中，即持久化
		//先保存多对一的一端可减少SQL执行条数
		session.save(customer1);
		session.save(customer2);
		
		session.save(order1);
		session.save(order2);
		
	}
	
	/**
	 * 测试加载
	 */
	@Test
	public void testMany2ontLoad(){
		Order order1 = (Order) session.load(Order.class,3);
		System.out.println(order1);
		System.out.println(order1.getCustomer());
	}
}
