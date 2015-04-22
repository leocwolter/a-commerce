package br.com.acommerce.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acommerce.model.Book;

public class BookDAO {

	private Connection connection;

	public BookDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Book book) {
		try {
			String sql = "insert into book (name, genre, price, authors) values ( ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getGenre());
			preparedStatement.setString(3, book.getPrice().toPlainString());
			preparedStatement.setString(4, book.getAuthors());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Book> all() {
		try {
			String sql = "select * from book";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Book> books = new ArrayList<>();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String genre = resultSet.getString("genre");
				BigDecimal price = new BigDecimal(resultSet.getString("price"));
				String authors = resultSet.getString("authors");
				books.add(new Book(name, genre, price, authors));
			}
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
