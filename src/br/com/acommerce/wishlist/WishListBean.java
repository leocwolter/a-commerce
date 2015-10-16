package br.com.acommerce.wishlist;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.book.Book;
import br.com.acommerce.user.UserSessionBean;

@Named
@RequestScoped
public class WishListBean {
	
	@Inject
	private UserSessionBean userSessionBean;
	@Inject
	private WishListDAO wishList;
	
	private List<Book> list;
	
	@PostConstruct
	public void setup(){
		list = wishList.of(userSessionBean.getUser());
	}
	
	public void add(Book book){
		wishList.add(book, userSessionBean.getUser());
		setup();
	}
	
	public void remove(Book book){
		wishList.remove(book);
		setup();
	}
	
	public boolean contains(Book book){
		return wishList.of(userSessionBean.getUser()).contains(book);
	}
	
	public List<Book> getList() {
		return list;
	}
	
}
