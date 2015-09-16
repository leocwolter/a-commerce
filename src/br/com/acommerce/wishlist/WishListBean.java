package br.com.acommerce.wishlist;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.book.Book;
import br.com.acommerce.user.UserSessionBean;

@Named
@SessionScoped
public class WishListBean implements Serializable{
	
	@Inject
	private UserSessionBean userSessionBean;
	@Inject
	private WishListDAO wishList;

	public void add(Book book){
		wishList.add(book, userSessionBean.getUser());
	}
	
	public void remove(Book book){
		wishList.remove(book);
	}
	
	public boolean contains(Book book){
		return wishList.of(userSessionBean.getUser()).contains(book);
	}
	
	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}
}
