package br.com.acommerce.checkout;

import br.com.acommerce.book.Book;

public class OrderedBook {

	private Long id;
	private Book book;
	private Long quantity;
	private Order order;

	public OrderedBook(Order order, Book book, Long quantity) {
		this.order = order;
		this.book = book;
		this.quantity = quantity;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Order getOrder() {
		return order;
	}

}
