package br.com.acommerce.category;


public class Category {

	private Long id;
	private String name;

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public Long getId() {
		return id;
	}
}
