package SpringSE.annoatation.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	public UserController() {
		System.out.println("UserController is constratror...");
	}
	
	public void execute(){
		System.out.println("UserController::execute is called...");
	}
}
