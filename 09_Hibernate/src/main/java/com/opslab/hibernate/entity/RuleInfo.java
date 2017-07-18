package com.opslab.hibernate.entity;

import java.util.Set;

public class RuleInfo {
	private Integer RuleId;
	
	private String  ruleName;
	
	private String  comment;
	
	private Set<UserInfo> userSet;

	public Integer getRuleId() {
		return RuleId;
	}

	public void setRuleId(Integer ruleId) {
		RuleId = ruleId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<UserInfo> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<UserInfo> userSet) {
		this.userSet = userSet;
	}
	
}
