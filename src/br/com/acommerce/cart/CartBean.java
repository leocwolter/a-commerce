package br.com.acommerce.cart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.book.Book;
import br.com.acommerce.infra.MessageContainer;

@SessionScoped
@Named
public class CartBean implements Serializable {
	
	@Inject
	private MessageContainer messages;
	
	private Cart cart = new Cart();
	private Book book;
	
	public String add() {
		cart.add(book);
		return "success?faces-redirect=true";
	}
	
	public void remove(Book book) {
		cart.remove(book);
		messages.addInfo("itemRemoved");
	}
	
	public String showFinalPrice() {
		return "show-final-price?faces-redirect=true";
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
	
	public Cart getCart() {
		return cart;
	}

	public void clean() {
		cart = new Cart();
	}

	public ShippingOption[] getShippingOptions(){
		return ShippingOption.values();
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
}
