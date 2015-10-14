package br.com.acommerce.book;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class BooksBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private BookDAO books;
	private Book book = new Book();
	private List<Book> all;
	
	@PostConstruct
	public void setup(){
		this.all = books.all();
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
		setup();
		return "list?faces-redirect=true";
	}
	
	public String delete(Book book){
		books.remove(book.getId());
		setup();
		return "list?faces-redirect=true";
	}
	
}
