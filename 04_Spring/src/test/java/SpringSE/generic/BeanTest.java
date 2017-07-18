package SpringSE.generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/* 
		 * 在base基类中利用注解建立的注入关系。
		 * 
		 * 在子类中spring会按照关系完成子类的注入
		 * 
		 * 该例子中为userService注入了userRepository的实例，而不是baseRepository实例
		 */
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/conf/applicationContext-generic.xml");
		
		UserService userService = (UserService) context.getBean("userService");
		
		userService.add();
	}
}
