package com.opslab.hibernate.entity;

public class PersonVO {
	private Integer PersonId;
	
	private String  PersonName;
	
	private String  sex;

	public Integer getPersonId() {
		return PersonId;
	}

	public void setPersonId(Integer personId) {
		PersonId = personId;
	}

	public String getPersonName() {
		return PersonName;
	}

	public void setPersonName(String personName) {
		PersonName = personName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "PersonVO [PersonId=" + PersonId + ", PersonName=" + PersonName + ", sex=" + sex + "]";
	}
	

}
