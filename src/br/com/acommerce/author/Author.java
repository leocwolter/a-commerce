package br.com.acommerce.author;

import java.util.Calendar;


public class Author {

	private Long id;
	private String name;
	private Calendar birthDay;
	private String biography;
	private String cpf;
	private String street;
	private String city;
	private String state;
	private String country;
	private Integer number;
	private String complement;
	private String zipCode;
	
	public Author(String name, Calendar birthDay, String biography, String cpf,
			String street, String city, String state, String country,
			Integer number, String complement, String zipCode) {
		this.name = name;
		this.birthDay = birthDay;
		this.biography = biography;
		this.cpf = cpf;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.number = number;
		this.complement = complement;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Calendar getBirthDay() {
		return birthDay;
	}

	public String getBiography() {
		return biography;
	}

	public String getCpf() {
		return cpf;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public Integer getNumber() {
		return number;
	}

	public String getComplement() {
		return complement;
	}

	public String getZipCode() {
		return zipCode;
	}


}
