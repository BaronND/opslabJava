package com.opslab.hibernate.entity;


public class UserInfo {
	
	private Integer  userId;
	
	private String 	 userName;
	
	private RuleInfo ruleInfo;

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

	public RuleInfo getRuleInfo() {
		return ruleInfo;
	}

	public void setRuleInfo(RuleInfo ruleInfo) {
		this.ruleInfo = ruleInfo;
	}
	
}
