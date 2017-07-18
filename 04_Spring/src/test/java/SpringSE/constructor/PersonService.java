package SpringSE.constructor;

import org.springframework.context.ApplicationContext;

import SpringSE.Context;

public class PersonService {
	private String name ="这是默认的名字";
	
	private String say ="当构造方法多个参数时可以通过type和Index指定参数的对应关系";
	
	private int age = 20;
	

	public void setName(String name) {
		this.name = name;
	}

	public void info() {
		System.out.println("此人名为：" + name +"\t"+age+"\t"+say);
	}

	public PersonService(String name) {
		this.name = name;
	}

	
	public PersonService(String name, String say, int age) {
		super();
		this.name = name;
		this.say = say;
		this.age = age;
	}

	public PersonService() {
		
		
	}
	
	public static void main(String[] args){
		ApplicationContext ctx = Context.getAppContext();
		PersonService test =(PersonService) ctx.getBean("person1");
		PersonService test1 =(PersonService) ctx.getBean("person2");
		PersonService test2 =(PersonService) ctx.getBean("person3");
		PersonService test3 =(PersonService) ctx.getBean("person4");
		test.info();
		test1.info();
		test2.info();
		test3.info();
	
	}

}
