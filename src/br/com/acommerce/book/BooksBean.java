package br.com.acommerce.book;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class BooksBean {
	
	@Inject
	private BookDAO books;
	private Book book;
	
	public List<Book> getList() throws SQLException{
		return books.all();
	}
	
	public String show(Book book){
		this.book = book;
		return "show?faces-redirect=true";
	}
}
