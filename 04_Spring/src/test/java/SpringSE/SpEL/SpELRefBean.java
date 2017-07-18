package SpringSE.SpEL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * @author admins
 * @summary:
 * 		通过SpEL配置引用一个bean，并调用注入一个bean的属性和方法
 */
public class SpELRefBean {
	private  Long injectId;
	
	private  String  injectName;
	
	private  String  injectInfo;
	
	private  Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getInjectId() {
		return injectId;
	}

	public void setInjectId(Long injectId) {
		this.injectId = injectId;
	}

	public String getInjectName() {
		return injectName;
	}

	public void setInjectName(String injectName) {
		this.injectName = injectName;
	}

	
	public String getInjectInfo() {
		return injectInfo;
	}

	public void setInjectInfo(String injectInfo) {
		this.injectInfo = injectInfo;
	}


	@Override
	public String toString() {
		return "SpELRefBean [injectId=" + injectId + ", injectName="
				+ injectName + ", injectInfo=" + injectInfo + ", customer="
				+ customer + "]";
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/conf/applicationContext-spel.xml");
		
		SpELRefBean beans = (SpELRefBean) context.getBean("spelRefBean");
		System.out.println(beans);
	}
}
