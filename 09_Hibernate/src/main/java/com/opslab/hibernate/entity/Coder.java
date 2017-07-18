package com.opslab.hibernate.entity;

public class Coder {
	private long id;
	
	private String name;
	
	private String sex;
	
	private Skill skill;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Coder [id=" + id + ", name=" + name + ", sex=" + sex + ", skill=" + skill + "]";
	}

	
}
