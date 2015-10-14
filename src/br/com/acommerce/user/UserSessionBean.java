package br.com.acommerce.user;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class UserSessionBean implements Serializable {
	@Inject
	private UserDAO users;
	private User user;
	
	public String signup(String email, String password){
		users.save(new User(email, password));
		return login(email, password);
	}
	
	public String login(String email, String password) {
		this.user = users.getWithEmailAndPassword(email, password);
		return "/home?faces-redirect=true";
	}
	
	public String logout(){
		this.user = null;
		return "/home?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}
	
	public boolean isLogged() {
		return user != null;
	}
}
