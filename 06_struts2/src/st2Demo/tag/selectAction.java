package st2Demo.tag;


public class selectAction {
	
	
	private String citys;
	
	private String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCitys() {
		return citys;
	}

	public void setCitys(String citys) {
		this.citys = citys;
	}

	@Override
	public String toString() {
		return "selectAction [citys=" + citys + ", age=" + age + "]";
	}
	
	public String cityListAction(){
		System.out.println(this.getClass()+":"+this);
		
		return "input";
	}

}
