package services;

import org.junit.Test;

import app.entries.BusinessLog;
import app.service.BusinessLogService;

public class BusinesslogServiceTest extends TestUtil{
	
	@Test
	public void BusLogTest(){
		BusinessLogService businessLogService = (BusinessLogService) Context.getBean("businessLogService");
		
		BusinessLog log = new BusinessLog();
		
		log.setAddress("127.0.0.1");
		
		businessLogService.save(log);
		
	}
}
