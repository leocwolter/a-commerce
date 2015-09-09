package br.com.acommerce.book;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.acommerce.infra.ConnectionFactory;

@ManagedBean
public class BooksBean {
	
	public List<Book> getList(){
		BookDAO books = new BookDAO(ConnectionFactory.getConnection());
		return books.all();
	}
	
	public void show(Book book){
		
	}
}
