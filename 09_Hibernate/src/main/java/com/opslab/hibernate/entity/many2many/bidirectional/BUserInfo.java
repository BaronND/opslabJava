package com.opslab.hibernate.entity.many2many.bidirectional;

import java.util.HashSet;
import java.util.Set;

public class BUserInfo {
	private Integer  userId;
	
	private String userName;
	
	private Set<BRuleInfo> ruleSet = new HashSet<BRuleInfo>();

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

	public Set<BRuleInfo> getRuleSet() {
		return ruleSet;
	}

	public void setRuleSet(Set<BRuleInfo> ruleSet) {
		this.ruleSet = ruleSet;
	}

	@Override
	public String toString() {
		return "BUserInfo [userId=" + userId + ", userName=" + userName + "]";
	}
	
	
}
