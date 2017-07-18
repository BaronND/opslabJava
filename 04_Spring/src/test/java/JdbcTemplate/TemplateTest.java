package JdbcTemplate;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TemplateTest {
	
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	/**
	 * @Summary
	 * 	测试数据源的连通性
	 */
	@Test
	public void testDateSource(){
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
	}
	
	
	
}
