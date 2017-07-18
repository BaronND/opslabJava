package SpringSE.lee;

import org.springframework.context.ApplicationContext;

import SpringSE.Context;
import SpringSE.constructor.PersonService;

public class SpringTest
{
	public static void main(String[] args)
	{
		//创建Spring的ApplicationContext
		ApplicationContext ctx = Context.getAppContext();
		//输出Spring容器
		System.out.println(ctx);
		PersonService p = ctx.getBean("personService" , PersonService.class);
		p.info();	
		
		PersonService p1	=(PersonService) ctx.getBean("person");
		p1.info();
	}
}
