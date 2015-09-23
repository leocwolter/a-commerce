package br.com.acommerce.book;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class BooksBean implements Serializable{
	
	@Inject
	private BookDAO books;
	private Book book;
	
	public List<Book> getList() throws SQLException{
		return books.all();
	}
	
	public String show(Book book){
		this.book = book;
		return "show?faces-redirect=true&includeViewParams=true";
	}
	
	public Book getBook() {
		return book;
	}
	
}
