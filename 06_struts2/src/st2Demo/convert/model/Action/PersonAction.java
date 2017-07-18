package st2Demo.convert.model.Action;

import st2Demo.convert.model.CRM.Person;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PersonAction extends ActionSupport implements ModelDriven<Person> {
	private static final long serialVersionUID = 1L;
	
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public Person getModel() {
		person = new Person();
		return person;
	}
	
	public String execute(){
		System.out.println(this.person);
		return "success";
				
	}

}
