package br.com.acommerce.dao;

import java.sql.Connection;

import br.com.acommerce.model.Book;

public class BookDAO {

	private Connection connection;

	public BookDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Book book) {
		
	}

}
