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
	
	private Category category = new Category();
	
	public List<Category> getList(){
		return categories.all();
	}
	
	public String save(){
		categories.save(category);
		return "/list?faces-redirect=true";
	}
	
	public String delete(Category category){
		categories.remove(category.getId());
		return "/list?faces-redirect=true";
	}
	
	public String update(){
		categories.update(category);
		return "/list?faces-redirect=true";
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Category getCategory() {
		return category;
	}
}
