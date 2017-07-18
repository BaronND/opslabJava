package SpringSE.factory;

import org.springframework.beans.factory.FactoryBean;

public class ProductFactoryBean implements FactoryBean<Product> {

	
	/*
	 * 返回一个Product的实例
	 */
	@Override
	public Product getObject() throws Exception {
		return new Product(System.currentTimeMillis(), "mac", 10000F);
	}
	
	/*
	 * 返回实例的类型
	 */
	@Override
	public Class<?> getObjectType() {
		return Product.class;
	}

	/*
	 * 是否是单例
	 */
	@Override
	public boolean isSingleton() {
		return false;
	}

}
