package br.com.acommerce.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class UserSessionBean {
	private User user;
	
	public void login(String email, String password) {
		this.user = new User(email, password);
	}

	public User getUser() {
		return user;
	}
	
	public boolean isLogged() {
		return user != null;
	}
}
