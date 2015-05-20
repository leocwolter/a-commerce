package br.com.acommerce.book;

import static java.util.stream.Collectors.joining;

import java.math.BigDecimal;
import java.util.List;

import br.com.acommerce.author.Author;
import br.com.acommerce.category.Category;
import br.com.acommerce.publisher.Publisher;

public class Book {

	private Long id;
	private String name;
	private BigDecimal price;
	private List<Category> categories;
	private Publisher publisher;
	private List<Author> authors;
	private String synopsis;
	private String toc;
	private Integer length;
	private String language;

	public Book(String name, List<Category> categories, Publisher publisher,
			BigDecimal price, List<Author> authors, String synopsis, String toc,
			Integer length, String language) {
		this.name = name;
		this.categories = categories;
		this.publisher = publisher;
		this.price = price;
		this.authors = authors;
		this.synopsis = synopsis;
		this.toc = toc;
		this.length = length;
		this.language = language;
	}
	
	public String getSynopsis() {
		return synopsis;
	}
	
	public String getToc() {
		return toc;
	}
	
	public Integer getLength() {
		return length;
	}
	
	public String getLanguage() {
		return language;
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

	public boolean isWrittenBy(Author author){
		return authors.stream().map(Author::getId).anyMatch(id -> id.equals(author.getId()));
	}

	public List<Category> getCategories() {
		return categories;
	}

	public String getCategoriesAsString() {
		return categories.stream().map(Category::getName).collect(joining(", "));
	}
	
	public String getAuthorsAsString() {
		return authors.stream().map(Author::getName).collect(joining(", "));
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
