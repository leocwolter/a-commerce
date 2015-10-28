package br.com.acommerce.user;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class SignupBean {
	
	@Inject
	private UserDAO users;
	@Inject
	private UserSessionBean session;
	private User user;
	
	@PostConstruct
	public void setup(){
		user = new User();
	}
	
	public String signup(String email, String password){
		users.save(new User(email, password));
		setup();
		return session.login(email, password);
	}
	
	public User getUser() {
		return user;
	}
}
