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

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Calendar birthDay) {
		this.birthDay = birthDay;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	

}
