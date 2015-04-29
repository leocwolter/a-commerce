package br.com.acommerce.book;

import java.math.BigDecimal;
import java.util.List;

public class Book {

	private String name;
	private String authors;
	private BigDecimal price;
	private String genre;

	public Book(String name, String genre, BigDecimal price, String authors) {
		this.name = name;
		this.genre = genre;
		this.price = price;
		this.authors = authors;
	}

	public String getName() {
		return name;
	}

	public String getAuthors() {
		return authors;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getGenre() {
		return genre;
	}

}
