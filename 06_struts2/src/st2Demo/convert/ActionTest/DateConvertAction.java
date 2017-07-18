package st2Demo.convert.ActionTest;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

public class DateConvertAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private Integer age;

	
	private Date brith;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
	public Date getBrith() {
		return brith;
	}

	@RequiredFieldValidator(key="required",
			message="!!! MISSING required MESSAGE !!!")
	public void setBrith(Date brith) {
		this.brith = brith;
	}
	

	@Override
	public String toString() {
		return "DateConvertAction [age=" + age + ", brith=" + brith + "]";
	}

	
	public String execute(){
		System.out.println(this);
		return "success";
	}
}
