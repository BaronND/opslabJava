package st2Demo.validation.hello.Action;

import st2Demo.validation.hello.CRM.Person;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PersonActionTest extends ActionSupport implements ModelDriven<Person>{

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
		System.out.println("PersonActionTest:"+this.person);
		return SUCCESS;
	}

}
