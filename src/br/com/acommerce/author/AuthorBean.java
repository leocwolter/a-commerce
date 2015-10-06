package br.com.acommerce.author;

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
		return "list";
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Author getAuthor() {
		return author;
	}
	
}
