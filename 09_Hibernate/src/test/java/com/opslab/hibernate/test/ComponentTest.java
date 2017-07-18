package com.opslab.hibernate.test;


import com.opslab.hibernate.entity.Coder;
import com.opslab.hibernate.entity.Skill;
import org.junit.Test;

public class ComponentTest extends SuperTest{

	
	/**
	 * 测试hibernate组成关系映射
	 */
	@Test
	public void testComponentSave(){

		
		Skill skill = new Skill();
		
		skill.setOs("linux");
		skill.setLanguage("Java/Python/web");
		skill.setAdept("AV");
		
		Coder coder = new Coder();
		coder.setName("N");
		coder.setSex("男");
		coder.setSkill(skill);
		
		Coder coder1 = new Coder();
		coder1.setName("N");
		coder1.setSex("男");
		coder1.setSkill(skill);
		
		//注意此处不能将skill对象进行持久化，因为它是值类型的
		session.save(coder);
		session.save(coder1);
	}
	@Test
	public void testComponentLoad(){
		Coder coder = (Coder) session.load(Coder.class, (long)5);
		System.out.println(coder);
		System.out.println(coder.getSkill());
	}
	
}
