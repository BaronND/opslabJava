package st2Demo.convert.configXML.CRM;

import java.util.Date;

public class Person {
	private Integer personId;
	
	private String personName;
	
	private Date birth;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", birth=" + birth + "]";
	}
	
}
