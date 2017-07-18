package com.opslab.hibernate.entity;

public class UserVO {
	private long  recordid;
	
	private String userid;
	
	private String username;

	public long getRecordid() {
		return recordid;
	}

	public void setRecordid(long recordid) {
		this.recordid = recordid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserVO [recordid=" + recordid + ", userid=" + userid
				+ ", username=" + username + "]";
	}
	
	
}
