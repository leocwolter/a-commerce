package br.com.acommerce.user;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.infra.MessageContainer;

@Named
@RequestScoped
public class UserBean {
	
	@Inject
	private UserDAO users;
	@Inject
	private MessageContainer messages;
	
	private User user;
	
	@PostConstruct
	public void setup(){
		this.user = new User();
	}
	 

	public void validateNewUser(FacesContext context, UIComponent component, Object value){
		String email = value.toString();
		if(users.existsWith(email)) {
			messages.throwError("userExists");
		}
	}
	
	public void delete(User user){
		users.remove(user);
		messages.addInfo("deleted");
	}
	
	public void edit() {
		users.update(user);
		messages.addInfo("updated");
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
