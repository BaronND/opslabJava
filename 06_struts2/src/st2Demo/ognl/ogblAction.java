package st2Demo.ognl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**************************************
 * 
 * @author admins
 * @summary:
 * 		测试struts2的ognl
 */
public class ogblAction extends ActionSupport implements ApplicationAware, RequestAware, SessionAware{

	private static final long serialVersionUID = 1L;
	
	private List<Person> persons;
	
	private Map<String, Object> requestMap;
	
	private Map<String, Object> sessionMap;
	
	private Map<String, Object> applicationMap;
	
	public String execute(){
		applicationMap.put("msg", "application-msg");
		
		sessionMap.put("msg","session-msg");
		
		requestMap.put("msg","request-msg");
		
		persons = new ArrayList<Person>();
		Person person1 = new Person();  
		person1.setName("pla1");  
        person1.setAge(26);  
        person1.setBirthday(new Date());  
        persons.add(person1);  
  
        Person person2 = new Person();  
        person2.setName("pla2");  
        person2.setAge(36);  
        person2.setBirthday(new Date());  
        persons.add(person2);  
  
        Person person3 = new Person();  
        person3.setName("pla3");  
		person3.setAge(16);  
		person3.setBirthday(new Date());  
		persons.add(person3);  
		
		return "success";
	}
	
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.applicationMap=arg0;
	}
	
}
