package br.com.acommerce.wishlist;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.book.Book;
import br.com.acommerce.infra.MessageContainer;
import br.com.acommerce.user.UserSessionBean;

@Named
@RequestScoped
public class WishListBean {
	
	@Inject
	private UserSessionBean userSessionBean;
	@Inject
	private WishListDAO wishList;
	@Inject
	private MessageContainer messages;
	
	private List<Book> list;
	
	@PostConstruct
	public void setup(){
		if(userSessionBean.isLogged()){
			list = wishList.of(userSessionBean.getUser());
		}
	}
	
	public void add(Book book){
		wishList.add(book, userSessionBean.getUser());
		setup();
		messages.addInfo("itemAdded");
	}
	
	public void remove(Book book){
		wishList.remove(book);
		setup();
		messages.addInfo("itemRemoved");
	}
	
	public boolean contains(Book book){
		return wishList.of(userSessionBean.getUser()).contains(book);
	}
	
	public List<Book> getList() {
		return list;
	}
	
}
