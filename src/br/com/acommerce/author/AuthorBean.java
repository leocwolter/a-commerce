package br.com.acommerce.author;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuthorBean {

	@Inject
	private AuthorDAO authors;
	
	private Author author = new Author();
	
	public String save(){
		authors.save(author);
		return "list?faces-redirect=true";
	}
	
	public String update(){
		authors.update(author);
		return "list?faces-redirect=true";
	}
	
	public void delete(Author author) {
		authors.remove(author.getId());
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public List<Author> getList() {
		return authors.all();
	}
	
}
