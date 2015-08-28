package br.com.acommerce.book;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.acommerce.author.Author;
import br.com.acommerce.category.Category;
import br.com.acommerce.publisher.Publisher;

@ManagedBean
public class BooksBean {
	
	public List<Book> getList(){
		List<Category> categories = Collections.emptyList();
		Publisher publisher = new Publisher("teste", null, null, null, null, null, null, null, 0);
		List<Author> authors = Collections.emptyList();
		String synopsis = "sinopse";
		String toc = "tabela de conteudo";
		Integer length = 232;
		String language = "portugues";
		Book book = new Book("teste", categories, publisher, new BigDecimal(10.0), authors, synopsis, toc,
				length, language);
		book.setId(1L);
		Book book2 = new Book("outro teste", categories, publisher, new BigDecimal(20.0), authors, synopsis, toc, length, language);
		book2.setId(2L);
		return Arrays.asList(book, book2);
	}
	
	public void show(Book book){
		
	}
}
