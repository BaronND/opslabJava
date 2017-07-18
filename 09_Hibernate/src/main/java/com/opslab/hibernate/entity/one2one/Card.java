package com.opslab.hibernate.entity.one2one;

public class Card {
	private Integer Id;
	
	private String CradName;
	
	private Person person;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCradName() {
		return CradName;
	}

	public void setCradName(String cradName) {
		CradName = cradName;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Card [Id=" + Id + ", CradName=" + CradName + ", person=" + person + "]";
	}
	
}
