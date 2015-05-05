package br.com.acommerce.book;

import static java.util.stream.Collectors.joining;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.acommerce.category.Category;

public class Book {

	private String name;
	private String authors;
	private BigDecimal price;
	private Long id;
	private List<Category> categories;

	public Book(String name, List<Category> categories, BigDecimal price, String authors) {
		this.name = name;
		this.categories = categories;
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

	
	public boolean contains(String category){
		return categories.stream().map(Category::toString)
				.anyMatch((name) -> category.equals(name));
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
	
	

}
