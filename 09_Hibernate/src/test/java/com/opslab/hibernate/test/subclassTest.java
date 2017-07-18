package com.opslab.hibernate.test;

import com.opslab.hibernate.entity.extend.subclass.Employee;
import com.opslab.hibernate.entity.extend.subclass.Loader;
import com.opslab.hibernate.entity.extend.subclass.Managaer;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;


public class subclassTest extends SuperTest{


	@Test
	public void subclassTestSave() {
		Employee emp = new Employee();
		emp.setUserName("小和尚");
		
		Managaer man = new Managaer();
		man.setUserName("主持");
		man.setManagerDept("寺院");
		
		Loader load = new Loader();
		load.setUserName("方丈");
		load.setLoadDept("少林寺");
		
		session.save(emp);
		session.save(man);
		session.save(load);
	}
	
	@SuppressWarnings("unchecked")
	@Test 
	public void subclassTestLoad(){
		List<Employee> userlist =  session.createQuery("from Employee").list();
		Iterator<Employee> iter = userlist.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().toString());
		}
	}

}
