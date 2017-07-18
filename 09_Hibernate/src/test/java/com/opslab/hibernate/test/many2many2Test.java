package com.opslab.hibernate.test;

import com.opslab.hibernate.entity.many2many.bidirectional.BRuleInfo;
import com.opslab.hibernate.entity.many2many.bidirectional.BUserInfo;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Iterator;

public class many2many2Test extends SuperTest{
private  Configuration configuration;
	

	
	/**
	 * 映射双向对多映射
	 */
	@Test
	public void testMany2manySave(){
		BUserInfo user1 = new BUserInfo();
		BUserInfo user2 = new BUserInfo();
		
		BRuleInfo rule1 = new BRuleInfo();
		BRuleInfo rule2 = new BRuleInfo();
		
		user1.setUserName("和尚");
		user2.setUserName("尼姑");
		
		rule1.setRuleName("教徒");
		rule2.setRuleName("执法值");
		
		//设置关联关系
		user1.getRuleSet().add(rule1);
		user1.getRuleSet().add(rule2);
		
		user2.getRuleSet().add(rule1);
		user2.getRuleSet().add(rule2);
		
		session.save(user1);
		session.save(user2);
		
	}
	
	/**
	 * 测试双向多对多的加载
	 */
	@Test
	public void testMany2manyLoad(){
		BUserInfo user1 = (BUserInfo) session.load(BUserInfo.class, 1);
		System.out.println(user1.getUserName());
		
		Iterator<BRuleInfo> ruleSet = user1.getRuleSet().iterator();
		while(ruleSet.hasNext()){
			System.out.println(ruleSet.next());
		}
		
				
	}
}
