package SpringSE.generic;

/**
 * 此处使用spring注解，将service和repostiry关联到一起，然后子类中就自动注入
 */
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

	@Autowired
	private BaseRepository<T> repository;
	
	public void add(){
		repository.save();
		System.out.println(repository.getClass());
	}
	
}
