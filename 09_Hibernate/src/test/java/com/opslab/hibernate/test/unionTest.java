package com.opslab.hibernate.test;

import com.opslab.hibernate.entity.extend.union.CBook;
import com.opslab.hibernate.entity.extend.union.JavaBook;
import com.opslab.hibernate.entity.extend.union.book;
import org.junit.Test;

import java.util.Date;

public class unionTest extends SuperTest{


	
	@Test
	public void unionTestSave(){
		book  book1 = new book();
		book1.setBookName("易经");

		CBook book2 = new CBook();
		book2.setAuthor("AA");
		book2.setBookName("C语言编码规范");
		book2.setAbstracts("讲述C语言的编码规范");
		book2.setProductTime(new Date());
		
		JavaBook jbook = new JavaBook();
		jbook.setAuthor("李兴华");
		jbook.setBookName("java实战开发经典");
		
		session.save(book1);
		session.save(book2);
		session.save(jbook);
	}
}
