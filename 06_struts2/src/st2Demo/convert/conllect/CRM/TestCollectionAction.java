package st2Demo.convert.conllect.CRM;

import java.util.ArrayList;
import java.util.Collection;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestCollectionAction extends ActionSupport implements ModelDriven<Collection<Person>>{
	private static final long serialVersionUID = 5210599538358882383L;
	
	private Collection<Person> persons;
	
	public Collection<Person> getPersons() {
		return persons;
	}

	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}

	@Override
	public Collection<Person> getModel() {
		persons = new ArrayList<Person>();
		return persons;
	}

	public String execute(){
		System.out.println(this.persons);
		return "input";
	}
}
