package st2Demo.tag;

public class radioAction {
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "radioAction [sex=" + sex + "]";
	}
	
	
	public String sexAction(){
		System.out.println(this.getClass()+":"+this);
		return "input";
	}
}
