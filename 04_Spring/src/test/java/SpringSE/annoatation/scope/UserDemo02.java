package SpringSE.annoatation.scope;

/**
 * 利用注解指定改Bean是一个单例的bean
 */
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope("singleton")
@Component
public class UserDemo02 {
	public void execute(){
		System.out.println(this);
	}
}
