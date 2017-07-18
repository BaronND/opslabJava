package SpringSE.annoatation.component;

import org.springframework.stereotype.Component;

@Component
public class UserCompoent {
	public UserCompoent() {
		System.out.println("UserCompoent is constrator...");
	}
	public void execute(){
		System.out.println("UserCompoent::execute is called...");
	}
}
