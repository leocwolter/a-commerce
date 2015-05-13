package br.com.acommerce.author;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDAO {

	private Connection connection;

	public AuthorDAO(Connection connection) {
		this.connection = connection;
	}
	public void save(Author author) {
		try {
			String sql = "insert into author (name, birthDay, biography, zipCode, cpf, street, city, state, country, number, complement) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, author.getName());
			preparedStatement.setDate(2, new Date(author.getBirthDay().getTimeInMillis()));
			preparedStatement.setString(3, author.getBiography());
			preparedStatement.setString(4, author.getZipCode());
			preparedStatement.setString(5, author.getCpf());
			preparedStatement.setString(6, author.getStreet());
			preparedStatement.setString(7, author.getCity());
			preparedStatement.setString(8, author.getState());
			preparedStatement.setString(9, author.getCountry());
			preparedStatement.setInt(10, author.getNumber());
			preparedStatement.setString(11, author.getComplement());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
//
//	public List<Author> all() {
//		try {
//			String sql = "select * from category";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			List<Author> categories = new ArrayList<>();
//			while (resultSet.next()) {
//				String name = resultSet.getString("name");
//				Author category = new Author(name);
//				category.setId(resultSet.getLong("id"));
//				categories.add(category);
//			}
//			return categories;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public Author withId(Long id) {
//		try {
//			String sql = "select * from category where id = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setLong(1, id);
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			if(!resultSet.next())
//				throw new RuntimeException("Couldn't find any categories with id "+id);
//			
//			String name = resultSet.getString("name");
//			Author category = new Author(name);
//			category.setId(resultSet.getLong("id"));
//			return category;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public void update(Author category) {
//		try {
//			String sql = "update category set name = ? where id = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, category.getName());
//			preparedStatement.setLong(2, category.getId());
//			preparedStatement.execute();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public List<Author> ofBook(Long id) {
//		try {
//			String sql = "select distinct c.* from category c join book_category bc on bc.category_id = c.id where bc.book_id = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setLong(1, id);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			List<Author> categories = new ArrayList<>();
//			while (resultSet.next()) {
//				String name = resultSet.getString("name");
//				Author category = new Author(name);
//				category.setId(resultSet.getLong("id"));
//				categories.add(category);
//			}
//			return categories;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public void remove(Long id) {
//		try {
//			String sql = "delete from book_category where category_id = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setLong(1, id);
//			preparedStatement.execute();
//
//			sql = "delete from category where id = ?";
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setLong(1, id);
//			preparedStatement.execute();
//
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}

}
