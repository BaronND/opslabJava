package SpringSE.annoatation.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class UserDemo01 {
	public void execute(){
		System.out.println(this);
	}
}
