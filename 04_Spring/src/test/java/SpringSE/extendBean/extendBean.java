package SpringSE.extendBean;

import org.springframework.context.ApplicationContext;

import SpringSE.Context;

public class extendBean {

	public String name;
	public String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "extendBean [name=" + name + ", pass=" + pass + "]";
	}
	
	public static void main(String[] args){
		ApplicationContext ctx = Context.getAppContext();
		extendBean test = (extendBean)ctx.getBean("child");
		System.out.println(test);
	}
}
