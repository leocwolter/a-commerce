package br.com.acommerce.checkout;

import java.util.Calendar;
import java.util.List;

import br.com.acommerce.user.User;

public class Order {

	private final User user;
	private final Calendar creationDate = Calendar.getInstance();
	private List<OrderedBook> orderedBooks;

	public Order(List<OrderedBook> orderedBooks, User user) {
		this.orderedBooks = orderedBooks;
		this.user = user;
	}

}
