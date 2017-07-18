package SpringSE.AutoLoadBean;

import org.springframework.context.ApplicationContext;

import SpringSE.Context;

public class Demo1 {

	private		String	name;
	private		int		age;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	
	@Override
	public String toString() {
		return "Demo1 [name=" + name + ", age=" + age + "]";
	}


	public static void main(String[] args) {
		ApplicationContext ctx = Context.getAppContext();
		Demo1 test =(Demo1) ctx.getBean("tom");
		System.out.println(test);
		Demo1 test1 = (Demo1) ctx.getBean("tonny");
		System.out.println(test1);
	}

}
