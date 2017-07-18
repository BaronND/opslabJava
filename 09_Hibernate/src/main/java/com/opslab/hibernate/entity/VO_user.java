package com.opslab.hibernate.entity;

public class VO_user {
	private long recordid;
	
	private String userid;
	
	private String username;
	
	private String sex;
	
	private String content;


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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "VO_user [recordid=" + recordid + ", userid=" + userid + ", username=" + username + ", sex=" + sex + ", content=" + content + "]";
	}
}
