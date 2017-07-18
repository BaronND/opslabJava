package com.opslab.hibernate.entity.extend.union;

public class CBook extends book{
	private String abstracts;
	
	private String contents;

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}
