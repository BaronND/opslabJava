package com.opslab.hibernate.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class SessionTests {

	@Test
	public void testSessionCache() {
		Configuration config = new Configuration().configure();
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
//		//将id为1的用户从数据映射成POJO对象
//		UserVO vo =(UserVO)session.load(UserVO.class,(long)1);
//		System.out.println(vo);
//		
//		
//		//再次导入id为1的用户
//		UserVO vo2 = (UserVO)session.load(UserVO.class,(long)1);
//		System.out.println(vo2);
//		
//		//测试会发现俩个对象是相同的 及第二次hibernate不会再从数据库中导入，而是返回一个现有的对象
//		System.out.println(vo == vo2);
		
		session.close();
		sessionFactory.close();
	}

}
