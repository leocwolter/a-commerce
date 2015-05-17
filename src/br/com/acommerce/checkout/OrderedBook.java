package br.com.acommerce.checkout;

import java.math.BigDecimal;

import br.com.acommerce.book.Book;

public class OrderedBook {

	private Long id;
	private Book book;
	private Long quantity;
	private Order order;

	public OrderedBook(Book book, Long quantity) {
		this.book = book;
		this.quantity = quantity;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}
	
	public String getName() {
		return book.getName();
	}

	public Long getQuantity() {
		return quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
		
	}
	
	public BigDecimal getPrice(){
		return book.getPrice();
	}
	
	public BigDecimal getTotalPrice(){
		return book.getPrice().multiply(new BigDecimal(quantity));
	}
	
}
