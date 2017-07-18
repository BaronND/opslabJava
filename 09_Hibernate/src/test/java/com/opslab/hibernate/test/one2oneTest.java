package com.opslab.hibernate.test;


import com.opslab.hibernate.entity.one2one.foreginKey.Card;
import com.opslab.hibernate.entity.one2one.foreginKey.Person;
import org.junit.Test;

public class one2oneTest extends SuperTest{

	
	/**
	 *测试保存(主键关联)
	 */
	@Test
	public void testOne2oneSave(){
		Person person = new Person();
		person.setPersonName("和尚");
		
		Card card = new Card();
		card.setCradName("少林寺");
		
		person.setCard(card);
		card.setPerson(person);
		
		session.save(person);
		
	}
	
	/**
	 * 测试加载(主键关联)
	 */
	@Test
	public void testOne2oneLoad(){
		Person person = (Person) session.get(Person.class, 1);
		System.out.println(person.getPersonName());
		System.out.println(person.getCard().getPerson().getPersonName());
	}
	
	
	
}
