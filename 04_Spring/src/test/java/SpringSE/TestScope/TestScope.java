package SpringSE.TestScope;

import org.springframework.context.ApplicationContext;

import SpringSE.Context;

public class TestScope {
	
	public String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public static void main(String[] args){
		
		ApplicationContext ctx = Context.getAppContext();
		
		for(int i=0;i<5;i++){
			TestScope test = (TestScope) ctx.getBean("testScope");
			TestScope test1 = (TestScope) ctx.getBean("testScope1");
			//观察输出对象的hash
			System.out.println(test +"\t" + test1);	
		}

		
	}
}
