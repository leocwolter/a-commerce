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

	public Author() {
		this.birthDay = Calendar.getInstance();
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

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDay(Calendar birthDay) {
		this.birthDay = birthDay;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
		if(obj instanceof Long && id == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
