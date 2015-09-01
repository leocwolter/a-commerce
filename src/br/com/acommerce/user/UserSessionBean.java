package br.com.acommerce.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class UserSessionBean {
	private User user;
	
	public String signup(String email, String password){
		return login(email, password);
	}
	
	public String login(String email, String password) {
		this.user = new User(email, password);
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
