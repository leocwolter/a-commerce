package br.com.acommerce.author;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.infra.MessageContainer;

@Named
@RequestScoped
public class AuthorBean {

	@Inject
	private AuthorDAO authors;
	@Inject
	private MessageContainer messages;
	
	private Author author;

	@PostConstruct
	public void setup(){
		author = new Author();
	}
	
	public void save(){
		authors.save(author);
		messages.addInfo("created");
		setup();
	}
	
	public void update(){
		authors.update(author);
		messages.addInfo("updated");
	}
	
	public void delete(Author author) {
		authors.remove(author.getId());
		messages.addInfo("deleted");
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public List<Author> getList() {
		List<Author> authorList = authors.all();
		if(authorList.isEmpty()){
			messages.addInfo("noResults");
		}
		return authorList;
	}
	
}
