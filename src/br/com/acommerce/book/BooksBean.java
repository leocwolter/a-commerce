package br.com.acommerce.book;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class BooksBean {
	public List<Book> getList(){
		Book book = new Book("teste", null, null, new BigDecimal(10.0), null, null, null, null, null);
		book.setId(1L);
		Book book2 = new Book("outro teste", null, null, new BigDecimal(20.0), null, null, null, null, null);
		book2.setId(2L);
		return Arrays.asList(book, book2);
	}
}
