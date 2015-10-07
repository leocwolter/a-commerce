package br.com.acommerce.book;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BooksBean{
	
	@Inject
	private BookDAO books;
	private Book book = new Book();
	
	public List<Book> getList() throws SQLException{
		return books.all();
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public String save(){
		books.save(book);
		return "list?faces-redirect=true";
	}
	
	public String delete(Book book){
		books.remove(book.getId());
		return "list?faces-redirect=true";
	}
	
}
