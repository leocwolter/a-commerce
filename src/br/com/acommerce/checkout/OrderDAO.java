package br.com.acommerce.checkout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.acommerce.book.Book;

public class OrderDAO {

	private Connection connection;

	public OrderDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Order order) {
		
	}

}
