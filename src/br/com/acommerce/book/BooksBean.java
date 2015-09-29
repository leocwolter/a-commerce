package br.com.acommerce.book;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BooksBean implements Serializable{
	
	@Inject
	private BookDAO books;
	private Book book;
	
	public List<Book> getList() throws SQLException{
		return books.all();
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
}
