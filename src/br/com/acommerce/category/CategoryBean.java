package br.com.acommerce.category;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class CategoryBean {

	@Inject
	private CategoryDAO categories;
	
	public List<Category> getList(){
		return categories.all();
	}
}
