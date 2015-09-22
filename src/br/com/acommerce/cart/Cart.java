package br.com.acommerce.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import br.com.acommerce.book.Book;
import br.com.acommerce.checkout.Order;
import br.com.acommerce.checkout.OrderedBook;
import br.com.acommerce.user.User;

public class Cart {

	private Map<Book, Long> booksAndQuantity = new HashMap<>();
	private ShippingOption shippingOption;

	public void add(Book book) {
		if(booksAndQuantity.containsKey(book)) {
			Long quantity = booksAndQuantity.get(book) + 1;
			booksAndQuantity.put(book, quantity);
			return;
		}
		booksAndQuantity.put(book, 1L);
	}
	
	public Set<Book> getBooks() {
		return booksAndQuantity.keySet();
	}
	
	public Long howManyOf(Book book){
		return booksAndQuantity.get(book);
	}
	
	public BigDecimal getTotalPrice(){
		return booksAndQuantity.keySet().stream()
				.map(b -> b.getPrice().multiply(new BigDecimal(booksAndQuantity.get(b))))
				.reduce((before, after) -> before.add(after))
				.orElse(new BigDecimal("0.0"));
	}

	public void remove(Book book) {
		booksAndQuantity.remove(book);
	}

	public Order checkout(User user) {
		Set<Entry<Book,Long>> entrySet = booksAndQuantity.entrySet();
		List<OrderedBook> books = new ArrayList<>();
		for (Entry<Book, Long> entry : entrySet) {
			books.add(new OrderedBook(entry.getKey(), entry.getValue()));
		}
		return new Order(books, user, shippingOption);
	}

	public void setShippingOption(ShippingOption shippingOption) {
		this.shippingOption = shippingOption;

	}
	
	public BigDecimal getFinalPrice(){
		return getTotalPrice().add(shippingOption.getPrice());
	}
	
	public ShippingOption getShippingOption() {
		return shippingOption;
	}

}
