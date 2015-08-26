package br.com.acommerce.book;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class BooksBean {
	public List<Book> getList(){
		return Arrays.asList(new Book("teste", null, null, null, null, null, null, null, null));
	}
}
