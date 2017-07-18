package st2Demo.validate.Action;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private Integer age;
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
	public String execute(){
		System.out.println(this);
		return "success";
	}
}
