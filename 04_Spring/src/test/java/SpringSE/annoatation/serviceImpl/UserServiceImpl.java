package SpringSE.annoatation.serviceImpl;

import org.springframework.stereotype.Service;

import SpringSE.annoatation.service.UserService;


@Service(value="userService")
public class UserServiceImpl implements UserService {
	public void execute(){
		System.out.println("UserServiceImpl::execute  is called");
	}
}
