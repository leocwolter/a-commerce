package br.com.acommerce.user;

import javax.inject.Named;

@Named
public class UserBean {
	
	public String delete(){
		return "/home?faces-redirect=true";
	}
	
	public String edit() {
		return "/home?faces-redirect=true";
	}
}
