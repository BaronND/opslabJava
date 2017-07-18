package spring.javaSe.helloword.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;

import SpringSE.Context;
import spring.javaSe.helloword.bean.HelloWorld;

public class Test_HelloWorld {

	@Test
	public void say(){
		ApplicationContext ctx = Context.getAppContext();
		
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		helloWorld.say();
		
		
		//直接通过类型获取。注意输入改类型有多个bean实例走报错
		HelloWorld helloWorld2 = ctx.getBean(HelloWorld.class);
		helloWorld2.say();
		

	}
}
