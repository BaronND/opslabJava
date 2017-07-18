package SpringSE.annoatation.assist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredTest {
	@Autowired
	private  Long id;
	
	private  String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "autowiredTest [id=" + id + ", name=" + name + "]";
	}
	
	
}
