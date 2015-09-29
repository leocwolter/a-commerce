package br.com.acommerce.book;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class BookConverter implements Converter{

	@Inject
	private BookDAO books;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		return books.withId(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((Book)arg2).getId().toString();
	}

}
