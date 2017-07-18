package com.opslab.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
	
	/*
	 * hibernate一般的操作格式为：
	 * 1. 创建一个 Configuration 对象: 该对象封装了 Hibernate 的配置信息, 包括 cfg.xml 文件和 hbm.xml 文件
		Configuration configuration = new Configuration().configure();
		
		2. 创建 SessionFactory 对象: 该对象对应 Hiberante 配置文件对应的数据库和数据库表
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		3. 创建 Session 对象: Hiberante 应用和数据库的一个连接
		Session session = sessionFactory.openSession();
		
		4. 打开事务
		Transaction tx = session.beginTransaction();
		
		5. 执行CRUD操作
		VO obj = new News();
		obj.setContent("Hiberante");
		obj.setTitle("ORM");
		
		session.save(obj);
		
		6. 提交事务
		tx.commit();
		
		7. 关闭 Session 
		session.close();
		
		8. 关闭 SessionFactory
		sessionFactory.close();
	 */
	
	
	public static Configuration config = new Configuration().configure();
	
	public static SessionFactory sessionFactory = config.buildSessionFactory();
	
	//返回一个session，类似数据库连接
	public static Session getSession(){
		
		return sessionFactory.openSession();
		
	}
}
