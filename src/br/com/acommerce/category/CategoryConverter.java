package br.com.acommerce.category;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class CategoryConverter implements Converter{

	@Inject
	private CategoryDAO categories;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		return categories.withId(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2.getClass().isAssignableFrom(Category.class))
			return ((Category)arg2).getId().toString();
		
		return arg2.toString();
	}

}
