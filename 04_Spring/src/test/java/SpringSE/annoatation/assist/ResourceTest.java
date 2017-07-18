package SpringSE.annoatation.assist;



import javax.annotation.Resource;

import org.springframework.stereotype.Component;


@Component
public class ResourceTest {
	@Resource(name="id")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ResourceTest [id=" + id + "]";
	}
	
	
}
