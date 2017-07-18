package com.opslab.hibernate.entity.many2many;

import java.util.HashSet;
import java.util.Set;

public class RuleInfo {
	private Integer  ruleId;
	
	private String   ruleName;
	
	private Set<UserInfo> userSet = new HashSet<UserInfo>();

	public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public Set<UserInfo> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<UserInfo> userSet) {
		this.userSet = userSet;
	}

	@Override
	public String toString() {
		return "RuleInfo [ruleId=" + ruleId + ", ruleName=" + ruleName + "]";
	}
}
