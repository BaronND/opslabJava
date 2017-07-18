package SpringSE.AutoLoadBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import SpringSE.Context;


public class annotationDemo {

	public	Person	per;

	public Person getPer() {
		return per;
	}

	@Autowired
	public void setPer(Person per) {
		this.per = per;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = Context.getAppContext();
		annotationDemo test = (annotationDemo) ctx.getBean("autoDemo");
		test.per.say();
	}

}
