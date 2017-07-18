package com.opslab.hibernate.entity.extend.union;

public class JavaBook extends book{
	private String coreType;
	
	private String cotents;

	public String getCoreType() {
		return coreType;
	}

	public void setCoreType(String coreType) {
		this.coreType = coreType;
	}

	public String getCotents() {
		return cotents;
	}

	public void setCotents(String cotents) {
		this.cotents = cotents;
	}
	
}
