package com.opslab.hibernate.test;


import com.opslab.hibernate.entity.one2one.foreginKey.Card;
import com.opslab.hibernate.entity.one2one.foreginKey.Person;
import org.junit.Test;

public class one2one2Test extends SuperTest{

	
	/**
	 *测试保存(外键关联)
	 */
	@Test
	public void testOne2oneSave(){
		Person person = new Person();
		person.setPersonName("禅师");
		
		Card card = new Card();
		card.setCradName("少林寺");
		
		person.setCard(card);
		card.setPerson(person);
		
		session.save(person);
	}
	
	@Test
	public void testOne2oneLoad(){
		Person person = (Person) session.load(Person.class, 1);
		System.out.println(person.getPersonName());
		System.out.println(person.getCard().getPerson().getPersonName());
	}
	
}
