package st2Demo.convert.complext.CRM;

import java.util.Date;

public class Manager {
	private String name;
	private Date birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	@Override
	public String toString() {
		return "Marager [name=" + name + ", birth=" + birth + "]";
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
