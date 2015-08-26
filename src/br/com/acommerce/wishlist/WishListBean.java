package br.com.acommerce.wishlist;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.acommerce.book.Book;

@ManagedBean
@SessionScoped
public class WishListBean {
	
	private List<Book> wishList = new ArrayList<Book>();

	public void add(Book book){
		wishList.add(book);
	}
	
	public void remove(Book book){
		wishList.remove(book);
	}
	
	public boolean contains(Book book){
		return wishList.contains(book);
	}
}
