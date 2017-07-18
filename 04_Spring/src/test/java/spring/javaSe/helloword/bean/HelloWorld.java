package spring.javaSe.helloword.bean;

public class HelloWorld {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void say(){
		System.out.println("Hello :" + name);
	}
}
