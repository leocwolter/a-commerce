package br.com.acommerce.publisher;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.category.Category;

@RequestScoped
@Named
public class PublisherConverter implements Converter{

	@Inject
	private PublisherDAO publishers;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		return publishers.withId(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2.getClass().isAssignableFrom(Publisher.class))
			return ((Publisher)arg2).getId().toString();
		
		return arg2.toString();
	}

}
