package SpringSE.cycle;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Demo01 {

	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		System.out.println("Demo01 set Attribute");
		this.id = id;
	}

	public Demo01() {
		System.out.println("Demo01 is constructor");
	}
	
	public void init(){
		System.out.println("Demo01 init....");
	}
	
	public void destroy(){
		System.out.println("Demo01 destroy....");
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/conf/applicationContext-cycle.xml");
		Demo01 demo =(Demo01) context.getBean("Demo01");
		System.out.println(demo);
		
		//关闭IOC容器
		((ConfigurableApplicationContext)context).close();
	}
}
