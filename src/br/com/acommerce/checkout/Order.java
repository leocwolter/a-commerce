package br.com.acommerce.checkout;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import br.com.acommerce.cart.ShippingOption;
import br.com.acommerce.user.User;

public class Order {

	private Long id; 
	private final User owner; 
	private final List<OrderedBook> orderedBooks;
	private final ShippingOption shipping;
	private Calendar creationDate = Calendar.getInstance();

	public Order(List<OrderedBook> orderedBooks, User owner, ShippingOption shipping) {
		this.shipping = shipping;
		this.orderedBooks = orderedBooks;
		for (OrderedBook orderedBook : orderedBooks) {
			orderedBook.setOrder(this);
		}
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

	public ShippingOption getShippingOption() {
		return shipping;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}
	
	public BigDecimal getTotalPrice(){
		return orderedBooks.stream()
				.map(OrderedBook::getTotalPrice)
				.reduce((before, after) -> before.add(after))
				.orElse(new BigDecimal("0.0"))
				.add(shipping.getPrice());
	}
}
