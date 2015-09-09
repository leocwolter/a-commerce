package br.com.acommerce.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.acommerce.infra.ConnectionFactory;

@SessionScoped
@ManagedBean(name="userSessionBean")
public class UserSessionBean {
	private User user;
	
	public String signup(String email, String password){
		UserDAO users = new UserDAO(ConnectionFactory.getConnection());
		users.save(new User(email, password));
		return login(email, password);
	}
	
	public String login(String email, String password) {
		UserDAO users = new UserDAO(ConnectionFactory.getConnection());
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
