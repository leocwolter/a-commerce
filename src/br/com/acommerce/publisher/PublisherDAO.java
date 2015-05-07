package br.com.acommerce.publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO {

	private Connection connection;

	public PublisherDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Publisher publisher) {
		try {
			String sql = "insert into publisher (name, street, city, state, country, zipCode, cnpj, complement, number) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, publisher.getName());
			preparedStatement.setString(2, publisher.getStreet());
			preparedStatement.setString(3, publisher.getCity());
			preparedStatement.setString(4, publisher.getState());
			preparedStatement.setString(5, publisher.getCountry());
			preparedStatement.setString(6, publisher.getZipCode());
			preparedStatement.setString(7, publisher.getCnpj());
			preparedStatement.setString(8, publisher.getComplement());
			preparedStatement.setInt(9, publisher.getNumber());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
//
//	public List<Publisher> all() {
//		try {
//			String sql = "select * from category";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			List<Publisher> categories = new ArrayList<>();
//			while (resultSet.next()) {
//				String name = resultSet.getString("name");
//				Publisher category = new Publisher(name);
//				category.setId(resultSet.getLong("id"));
//				categories.add(category);
//			}
//			return categories;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public Publisher withId(Long id) {
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
//			Publisher category = new Publisher(name);
//			category.setId(resultSet.getLong("id"));
//			return category;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public void update(Publisher category) {
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
//	public List<Publisher> ofBook(Long id) {
//		try {
//			String sql = "select distinct c.* from category c join book_category bc on bc.category_id = c.id where bc.book_id = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setLong(1, id);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			List<Publisher> categories = new ArrayList<>();
//			while (resultSet.next()) {
//				String name = resultSet.getString("name");
//				Publisher category = new Publisher(name);
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
