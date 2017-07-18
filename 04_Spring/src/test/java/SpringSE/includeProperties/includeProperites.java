package SpringSE.includeProperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class includeProperites {
	private String user;

	private String pass;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/conf/applicationContext-includeProperties.xml");
		includeProperites bean = (includeProperites) ctx.getBean("db");
		System.out.println(bean.getUser()+"\t"+bean.getPass());
	}
}
