package SpringSE.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author admins
 * @summary:
 * 		测试静态工厂方法
 */
public class StaticProductFactory {

	private static Map<String, Product> productMap = new HashMap<String, Product>();
	
	
	static {
		
		productMap.put("console", new Product(System.currentTimeMillis(),"console",5000F));
		productMap.put("route", new Product(System.currentTimeMillis(),"route",50000F));
		productMap.put("RIDF", new Product(System.currentTimeMillis(),"HackRF",3000F));
	}
	
	public static Product getProductByName(String name){
		return productMap.get(name);
	}
}
