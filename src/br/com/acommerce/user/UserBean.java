package br.com.acommerce.user;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserBean {
	
	@Inject
	private UserDAO users;
	
	private User user = new User();
	 
	public String delete(User user){
		users.remove(user);
		return "/list?faces-redirect=true";
	}
	
	public String edit() {
		users.update(user);
		return "/list?faces-redirect=true";
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getList(){
		return users.all();
	}
}
