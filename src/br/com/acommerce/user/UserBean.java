package br.com.acommerce.user;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserBean {
	
	@Inject
	private UserSessionBean userSession;
	
	@Inject
	private UserDAO users;
	
	public String delete(){
		users.remove(userSession.getUser());
		return "/home?faces-redirect=true";
	}
	
	public String edit() {
		users.update(userSession.getUser());
		return "/home?faces-redirect=true";
	}
}
