package st2Demo.convert.configXML.ACTION;

import st2Demo.convert.model.CRM.Person;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @summary:
 * 		测试从web.xml读取配置信息，然后生成类型转换器
 */
public class PersonAction extends  ActionSupport implements ModelDriven<Person>{

	private static final long serialVersionUID = 1L;
	
	private  Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return "PersonAction [person=" + person + "]";
	}
	@Override
	public Person getModel() {
		person = new Person();
		return person;
	}

	
	public String execute(){
		System.out.println(this);
		return "success";
	}
}
