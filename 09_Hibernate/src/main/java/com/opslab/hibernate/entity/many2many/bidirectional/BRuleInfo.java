package com.opslab.hibernate.entity.many2many.bidirectional;

import java.util.HashSet;
import java.util.Set;

public class BRuleInfo {
	private Integer  ruleId;
	
	private String ruleName;
	
	private Set<BUserInfo> userSet = new HashSet<BUserInfo>();

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

	public Set<BUserInfo> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<BUserInfo> userSet) {
		this.userSet = userSet;
	}

	@Override
	public String toString() {
		return "BRuleInfo [ruleId=" + ruleId + ", ruleName=" + ruleName + "]";
	}
	
}
