package st2Demo.tag;

import java.util.ArrayList;
import java.util.List;


public class checkboxList{
	private List<checkbox> list;
	private List<String> skill;

	public List<checkbox> getList() {
		return list;
	}

	public void setList(List<checkbox> list) {
		this.list = list;
	}

	public List<String> getSkill() {
		return skill;
	}

	public void setSkill(List<String> skill) {
		this.skill = skill;
	}

	
	@Override
	public String toString() {
		return "checkboxList [list=" + list + ", skill=" + skill + "]";
	}

	public String execute(){
		System.out.println(this);
		list = new ArrayList<checkbox>();
		list.add(new checkbox("01","java"));
		list.add(new checkbox("02","web"));
		list.add(new checkbox("03","sql"));
		list.add(new checkbox("04","no-sql"));
		list.add(new checkbox("05","c/c++"));
		list.add(new checkbox("06","php"));
		list.add(new checkbox("07","python"));
		list.add(new checkbox("08","linux"));
		return "input";
	}

}
