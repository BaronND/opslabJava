package SpringSE.annoatation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	public UserRepository() {
		System.out.println("UserRepository is constartor ....");
	}
	
	public void execute(){
		System.out.println("UserRepository::execute is called ...");
	}
}
