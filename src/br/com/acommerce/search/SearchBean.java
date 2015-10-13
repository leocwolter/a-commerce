package br.com.acommerce.search;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.book.Book;
import br.com.acommerce.book.BookDAO;

@Named
@RequestScoped
public class SearchBean {
	
	@Inject
	private BookDAO books;

	private String query;

	private SearchableTable[] tables;
	
	public List<Book> getResult(){
		if(tables == null){
			return books.withNameLike(query);
		}
		return books.withData(query, asList(tables)).stream().collect(Collectors.toList());
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	public String getQuery() {
		return query;
	}

	public SearchableTable[] getTableValues(){
		return SearchableTable.values();
	}
	
	public SearchableTable[] getTables() {
		return tables;
	}

	public void setTables(SearchableTable[] tables) {
		this.tables = tables;
	}
	
	
}
