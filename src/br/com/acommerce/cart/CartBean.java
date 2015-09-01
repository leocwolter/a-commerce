package br.com.acommerce.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.acommerce.book.Book;


@ManagedBean
@SessionScoped
public class CartBean {
	
	private Cart cart = new Cart();
	
	public String add(Book book) {
		cart.add(book);
		return "cart/show?faces-redirect=true";
	}
	
	public String remove(Book book) {
		cart.remove(book);
		return "cart/show?faces-redirect=true";
	}
	
	public List<Book> getBooks() {
		return new ArrayList<>(cart.getBooks());
	}
	
	public Long howManyOf(Book book){
		return cart.howManyOf(book);
	}
	
	public BigDecimal getTotalPrice() {
		return cart.getTotalPrice();
	}
	
	public String chooseShipping(){
		return "cart/chooseShipping?faces-redirect=true";
	}
}
