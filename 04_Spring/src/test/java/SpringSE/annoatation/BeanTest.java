package SpringSE.annoatation;
/**********************************************************************
 * @Summary:
 * 		测试Spring的annoatation
 * 	
 *********************************************************************/
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import SpringSE.annoatation.assist.AutowiredTest;
import SpringSE.annoatation.assist.ResourceTest;
import SpringSE.annoatation.component.UserCompoent;
import SpringSE.annoatation.controller.UserController;
import SpringSE.annoatation.repository.UserRepository;
import SpringSE.annoatation.scope.UserDemo01;
import SpringSE.annoatation.scope.UserDemo02;
import SpringSE.annoatation.service.UserService;

public class BeanTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/conf/applicationContext-annoatation.xml");
		
		//测试annoation的自动配置
		UserCompoent userCompoent = (UserCompoent) context.getBean("userCompoent");
		
		userCompoent.execute();
		
		UserController userController = (UserController) context.getBean("userController");
		
		userController.execute();
		
		UserRepository userRepository= (UserRepository)context.getBean("userRepository");
		
		userRepository.execute();
		
		UserService userService = (UserService) context.getBean("userService");
		
		userService.execute();
		
		
		//测试注解的作用空间（注意输出对象的Hash）
		UserDemo01 userDemo01 = (UserDemo01) context.getBean("userDemo01");
		
		userDemo01.execute();
		
		UserDemo01 userDemo02 = (UserDemo01) context.getBean("userDemo01");
		
		userDemo02.execute();
		
		UserDemo02 userDemo03 = (UserDemo02) context.getBean("userDemo02");
		
		userDemo03.execute();
		
		UserDemo02 userDemo04 = (UserDemo02) context.getBean("userDemo02");
		
		userDemo04.execute();
		
		
		//测试Autowired 会根据类型自动注入
		AutowiredTest autowiredTest = (AutowiredTest) context.getBean("autowiredTest");
		
		System.out.println(autowiredTest);
		
		
		ResourceTest resource = (ResourceTest) context.getBean("resourceTest");
		
		System.out.println(resource);
		
	}
}
