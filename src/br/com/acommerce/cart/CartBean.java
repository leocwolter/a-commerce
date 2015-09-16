package br.com.acommerce.cart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.acommerce.book.Book;


@SessionScoped
@Named
public class CartBean implements Serializable {
	
	private Cart cart = new Cart();
	private ShippingOption shippingOption;
	
	public String add(Book book) {
		cart.add(book);
		return "cart/show?faces-redirect=true";
	}
	
	public String remove(Book book) {
		cart.remove(book);
		return "cart/show?faces-redirect=true";
	}
	
	public String showFinalPrice() {
		cart.setShippingOption(shippingOption);
		return "cart/show-final-price?faces-redirect=true";

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

	public Cart getCart() {
		return cart;
	}

	public void clean() {
		cart = new Cart();
	}

	public ShippingOption[] getShippingOptions(){
		return ShippingOption.values();
	}
	
	public ShippingOption getShippingOption() {
		return shippingOption;
	}
	
	public void setShippingOption(ShippingOption shippingOption) {
		this.shippingOption = shippingOption;
	}
}
