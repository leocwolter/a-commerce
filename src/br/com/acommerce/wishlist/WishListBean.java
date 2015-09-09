package br.com.acommerce.wishlist;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.acommerce.book.Book;
import br.com.acommerce.infra.ConnectionFactory;
import br.com.acommerce.user.UserSessionBean;

@ManagedBean
@SessionScoped
public class WishListBean {
	
	@ManagedProperty("#{userSessionBean}")
	private UserSessionBean userSessionBean;

	public void add(Book book){
		WishListDAO wishList = new WishListDAO(ConnectionFactory.getConnection());
		wishList.add(book, userSessionBean.getUser());
	}
	
	public void remove(Book book){
		WishListDAO wishList = new WishListDAO(ConnectionFactory.getConnection());
		wishList.remove(book);
	}
	
	public boolean contains(Book book){
		WishListDAO wishList = new WishListDAO(ConnectionFactory.getConnection());
		return wishList.of(userSessionBean.getUser()).contains(book);
	}
	
	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}
}
