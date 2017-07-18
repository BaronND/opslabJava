package com.opslab.hibernate.entity;

public class Skill {
	private String os;
	
	private String language;
	
	private String adept;
	
	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAdept() {
		return adept;
	}

	public void setAdept(String adept) {
		this.adept = adept;
	}

	@Override
	public String toString() {
		return "Skill [os=" + os + ", language=" + language + ", adept=" + adept + "]";
	}

}
