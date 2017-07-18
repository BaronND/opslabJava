package com.opslab.hibernate.entity.one2one;

public class Person {


	private Integer Id;
	
	private String PersonName;
	
	private Card card;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getPersonName() {
		return PersonName;
	}

	public void setPersonName(String personName) {
		PersonName = personName;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	@Override
	public String toString() {
		return "Person [Id=" + Id + ", PersonName=" + PersonName + ", card=" + card + "]";
	}
}
