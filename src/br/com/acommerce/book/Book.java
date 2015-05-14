package br.com.acommerce.book;

import static java.util.stream.Collectors.joining;

import java.math.BigDecimal;
import java.util.List;

import br.com.acommerce.author.Author;
import br.com.acommerce.category.Category;
import br.com.acommerce.publisher.Publisher;

public class Book {

	private String name;
	private BigDecimal price;
	private Long id;
	private List<Category> categories;
	private Publisher publisher;
	private List<Author> authors;

	public Book(String name, List<Category> categories, Publisher publisher, BigDecimal price, List<Author> authors) {
		this.name = name;
		this.categories = categories;
		this.publisher = publisher;
		this.price = price;
		this.authors = authors;
	}

	public String getName() {
		return name;
	}

	public List<Author> getAuthors() {
		return authors;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public boolean contains(Category category){
		boolean anyMatch = categories.stream().map(Category::getName)
				.anyMatch((name) -> category.getName().equals(name));
		return anyMatch;
	}

	public boolean isPublishedBy(Publisher publisher){
		return publisher.getName().equals(this.publisher.getName());
	}

	public List<Category> getCategories() {
		return categories;
	}

	public String getCategoriesAsString() {
		return categories.stream().map(Category::getName).collect(joining(", "));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Publisher getPublisher() {
		return publisher;
	}

}
