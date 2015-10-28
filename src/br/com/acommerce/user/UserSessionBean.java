package br.com.acommerce.user;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.infra.MessageContainer;

@SessionScoped
@Named
public class UserSessionBean implements Serializable {
	@Inject
	private UserDAO users;
	private User user;
	
	public String login(String email, String password) {
		this.user = users.getWithEmailAndPassword(email, password);
		return "home?faces-redirect=true";
	}
	
	public void logout(){
		this.user = null;
	}

	public User getUser() {
		return user;
	}
	
	public boolean isLogged() {
		return user != null;
	}
}
