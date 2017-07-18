package SpringSE.factory;
/**
 * 
 * @author admins
 * @summary:
 * 		所谓的实例工厂就是在使用该工厂的时候必须先进行实例化，然后再调用工厂方法
 */
import java.util.HashMap;
import java.util.Map;

public class InstanceProductFactory {
	
	
	public InstanceProductFactory() {
		productMap = new HashMap<String, Product>();
		
		productMap.put("console", new Product(System.currentTimeMillis(),"console",5000F));
		productMap.put("route", new Product(System.currentTimeMillis(),"route",50000F));
		productMap.put("RIDF", new Product(System.currentTimeMillis(),"HackRF",3000F));
	}
	
	private Map<String, Product> productMap;

	public Map<String, Product> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<String, Product> productMap) {
		this.productMap = productMap;
	}
	
	public Product getProductByName(String name){
		System.out.println("InstanceProductFactory::getProductByName is called");
		return productMap.get(name);
	}
}
