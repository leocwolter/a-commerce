package br.com.acommerce.search;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.book.Book;
import br.com.acommerce.book.BookDAO;

@Named
@RequestScoped
public class SimpleSearchBean {
	
	@Inject
	private BookDAO books;

	private String query;

	public List<Book> getResult(){
		return books.withNameLike(query);
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public String getQuery() {
		return query;
	}
}
