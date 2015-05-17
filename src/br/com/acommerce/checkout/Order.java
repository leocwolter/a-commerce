package br.com.acommerce.checkout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import br.com.acommerce.book.Book;
import br.com.acommerce.user.User;

public class Order {

	private Long id; 
	private final User owner; 
	private final Calendar creationDate = Calendar.getInstance();
	private final List<OrderedBook> orderedBooks;

	public Order(Map<Book, Long> booksAndQuantity, User owner) {
		Set<Entry<Book, Long>> entrySet = booksAndQuantity.entrySet();
		List<OrderedBook> orderedBooks = new ArrayList<>();
		for (Entry<Book, Long> entry : entrySet) {
			OrderedBook orderedBook = new OrderedBook(this, entry.getKey(), entry.getValue());
			orderedBooks.add(orderedBook);
		}
		this.orderedBooks = orderedBooks;
		this.owner = owner;
	}

	public List<OrderedBook> getOrderedBooks() {
		return orderedBooks;
	}

	public Long getId() {
		return id;
	}

	public User getOwner() {
		return owner;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
