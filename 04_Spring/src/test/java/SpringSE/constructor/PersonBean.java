package SpringSE.constructor;

import org.springframework.context.ApplicationContext;

import SpringSE.Context;

public class PersonBean {
	private Person person;
	
	private String name;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "PersonBean [person=" + person + ", name=" + name + "]";
	}

	public void say(){
		System.out.println(this);
	}
	public static void main(String[] args) {
		ApplicationContext context = Context.getAppContext();
		PersonBean person = (PersonBean) context.getBean("person5");
		person.say();
	}
}
