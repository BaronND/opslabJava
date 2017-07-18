package SpringSE.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * @author admins
 * @summary:
 * 		测试静态工厂方法
 */
public class ProductBean {
	/**
	 * 所谓的利用静态工厂配置bean就是调用工厂类的静态方法，返回一个想对象实例
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/conf/applicationContext-factory.xml");
		
		//利用静态工厂方法创建的实例
		Product product = (Product) context.getBean("staticFactoryBean");
		
		System.out.println(product);
		
		//利用实例工厂方法创建的实例
		Product product2 = (Product) context.getBean("instanceProduct");
		System.out.println(product2);
		
		//通过FactoryBean创建实例
		Product product3 =(Product) context.getBean("factoryBeanProduct");
		System.out.println(product3);
	}
}
