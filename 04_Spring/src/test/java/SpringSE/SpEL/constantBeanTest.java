package SpringSE.SpEL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 * @author admins
 * @summary:
 * 		测试spel的字面量
 */
public class constantBeanTest {
	private  Integer  id;
	
	private  Float   price;
	
	private  Double  productNum;
	
	private  Boolean isNeeds;
	
	private  String  productName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Double getProductNum() {
		return productNum;
	}

	public void setProductNum(Double productNum) {
		this.productNum = productNum;
	}

	public Boolean getIsNeeds() {
		return isNeeds;
	}

	public void setIsNeeds(Boolean isNeeds) {
		this.isNeeds = isNeeds;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "constantBeanTest [id=" + id + ", price=" + price
				+ ", productNum=" + productNum + ", isNeeds=" + isNeeds
				+ ", productName=" + productName + "]";
	}
	
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/conf/applicationContext-spel.xml");
		constantBeanTest beans  = (constantBeanTest) context.getBean("constant");
		System.out.println(beans);
	}
	
}
