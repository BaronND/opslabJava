package services;


import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUtil {

	public  ClassPathXmlApplicationContext Context;
	
	@Before
	public void before(){
		Context  = new ClassPathXmlApplicationContext("spring/Spring-beans-for-JUnit.xml");
	}
	
	@After
	public void after(){
		Context.close();
	}
	

}
