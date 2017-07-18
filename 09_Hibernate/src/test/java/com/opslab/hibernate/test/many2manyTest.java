package com.opslab.hibernate.test;

import java.util.Iterator;


import com.opslab.hibernate.entity.many2many.RuleInfo;
import com.opslab.hibernate.entity.many2many.UserInfo;
import org.junit.Test;

/**
 * 
 * 测试：单向多对对
 */
public class many2manyTest extends SuperTest{

	
	/**
	 * 单向多对多保存
	 */
	@Test
	public void testMany2manySave(){
		RuleInfo urle = new RuleInfo();
		urle.setRuleName("root");
		
		RuleInfo urle1 = new RuleInfo();
		urle1.setRuleName("dba");
		
		UserInfo user1 = new UserInfo();
		user1.getRuleSet().add(urle1);
		user1.getRuleSet().add(urle);
		
		session.save(user1);
	}
	
	/**
	 * 单向多对多加载
	 */
	@Test
	public void testMany2manyLoad(){
		UserInfo user1 = (UserInfo) session.load(UserInfo.class,1);
		System.out.println(user1.getUserName());
		Iterator<RuleInfo> ruleSet = user1.getRuleSet().iterator();
		while(ruleSet.hasNext()){
			System.out.println(ruleSet.next());
		}
	}
}
