package br.com.acommerce.book;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.infra.MessageContainer;

@Named
@SessionScoped
public class BooksBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private BookDAO books;
	@Inject
	private MessageContainer messages;
	
	private Book book;
	private List<Book> all;
	
	@PostConstruct
	public void setup(){
		this.all = books.all();
		this.book = new Book();
	}
	
	public List<Book> getList(){
		return all;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public String save(){
		books.save(book);
		messages.addInfo("created");
		setup();
		return "list?faces-redirect=true";
	}
	
	public void delete(Book book){
		books.remove(book.getId());
		messages.addInfo("deleted");
		setup();
	}
	
}
