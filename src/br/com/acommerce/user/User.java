package br.com.acommerce.user;

public class User {

	private Long id;
	private String email;
	private String password;
	private boolean admin;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User() {
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public boolean isAdmin() {
		return admin;
	}	
	
	

}
