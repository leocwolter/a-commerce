package br.com.acommerce.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class UserBean {
	
	public String delete(){
		return "/home?faces-redirect=true";
	}
	
	public String edit() {
		return "/home?faces-redirect=true";
	}
}
