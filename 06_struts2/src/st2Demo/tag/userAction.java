package st2Demo.tag;

public class userAction {
	private String userName;
	private String password;
	private String desc;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "userAction [userName=" + userName + ", password=" + password + ", desc=" + desc + "]";
	}

	public String login(){
		System.out.println(this);
		return "input";
	}
}
