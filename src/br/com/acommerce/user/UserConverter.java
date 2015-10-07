package br.com.acommerce.user;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class UserConverter implements Converter{

	@Inject
	private UserDAO users;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		return users.withId(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2.getClass().isAssignableFrom(User.class))
			return ((User)arg2).getId().toString();
		
		return arg2.toString();
	}

}
