package br.com.acommerce.cart;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.acommerce.book.Book;


@ManagedBean
@SessionScoped
public class CartBean {
	
	private List<Book> books = new ArrayList<>();
	
	public String add(Book book) {
		books.add(book);
		return "show-cart";
	}
	
	public String remove(Book book) {
		books.remove(book);
		return "show-cart";
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public int howManyOf(Book book){
		return 2;
	}
}
