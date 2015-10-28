package br.com.acommerce.category;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.infra.MessageContainer;


@Named
@RequestScoped
public class CategoryBean {

	@Inject
	private CategoryDAO categories;
	
	@Inject
	private MessageContainer messages;
	
	private Category category;
	
	@PostConstruct
	public void setup(){
		this.category = new Category();
	}
	
	public List<Category> getList(){
		return categories.all();
	}
	
	public void save(){
		categories.save(category);
		setup();
		messages.addInfo("created");
	}
	
	public String delete(Category category){
		categories.remove(category.getId());
		messages.addInfo("deleted");
		return "/list?faces-redirect=true";
	}
	
	public void update(){
		categories.update(category);
		messages.addInfo("updated");
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Category getCategory() {
		return category;
	}
}
