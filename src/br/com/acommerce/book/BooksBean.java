package br.com.acommerce.book;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.sql.DataSource;

@ManagedBean
public class BooksBean {
	
	@Resource(name="java:comp/acommerce")
	private DataSource dataSource;
	
	@Resource(name="java:comp/jdbc/acommerce")
	private DataSource anotherDataSource;
	
	public List<Book> getList() throws SQLException{
		BookDAO books = new BookDAO(dataSource.getConnection());
		return books.all();
	}
	
	public void show(Book book){
		
	}
}
