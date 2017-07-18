package st2Demo.ajax;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @summary:
 * 		利用ajax实现的注册Action 
 *
 */
public class ajaxRegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	private int age;
	
	private Date birht;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirht() {
		return birht;
	}

	public void setBirht(Date birht) {
		this.birht = birht;
	}
	
	@Override
	public String toString() {
		return "ajaxRegisterAction [username=" + username + ", password=" + password + ", age=" + age + ", birht=" + birht + "]";
	}

	@Override
	public String execute() throws Exception {
		System.out.println(this);
		return SUCCESS;
	}
}
