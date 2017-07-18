package SpringSE.collection;

import java.util.Properties;

import org.springframework.context.ApplicationContext;

import SpringSE.Context;

public class PropertiesBean {
	private Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "PropertiesBean [properties=" + properties + "]";
	}
	
	public static void main(String[] args) {
		ApplicationContext appContext = Context.getAppContext();
		PropertiesBean propertiesBean = (PropertiesBean) appContext.getBean("propertiesBean");
		String user = (String) propertiesBean.getProperties().get("user");
		System.out.println(user);
	}
}
