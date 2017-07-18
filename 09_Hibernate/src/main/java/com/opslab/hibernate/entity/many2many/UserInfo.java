package com.opslab.hibernate.entity.many2many;

import java.util.HashSet;
import java.util.Set;

public class UserInfo {
	private Integer userId;
	
	private String userName;
	
	private Set<RuleInfo> ruleSet = new HashSet<RuleInfo>();

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<RuleInfo> getRuleSet() {
		return ruleSet;
	}

	public void setRuleSet(Set<RuleInfo> ruleSet) {
		this.ruleSet = ruleSet;
	}
}
