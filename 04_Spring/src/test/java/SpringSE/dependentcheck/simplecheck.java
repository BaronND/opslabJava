package SpringSE.dependentcheck;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;

import SpringSE.Context;

public class simplecheck {

	
	
	private String name;
	
	private int	age;
	
	private	 SimpleDateFormat	sdf;
	
	public String getName() {
		return name;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@Required
	public void setAge(int age) {
		this.age = age;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	@Required
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	
	
	public void info() {
		System.out.println( "simplecheck [name=" + name + ", age=" + age + ", sdf=" + sdf
				+ "]");
	}

	public static void main(String[] args) {
		ApplicationContext ctx = Context.getAppContext();
		simplecheck test = (simplecheck)ctx.getBean("testdepentcheck");
		test.info();
		
	}

}
