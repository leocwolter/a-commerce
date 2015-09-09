package br.com.acommerce.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

	private Connection connection;

	public CategoryDAO(Connection connection) {
		this.connection = connection;
	}

	public void save(Category book) {
		try {
			String sql = "insert into category (name) values (?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Category> all() {
		try {
			String sql = "select * from category";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Category> categories = new ArrayList<>();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				Category category = new Category(name);
				category.setId(resultSet.getLong("id"));
				categories.add(category);
			}
			return categories;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Category withId(Long id) {
		try {
			String sql = "select * from category where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(!resultSet.next())
				throw new RuntimeException("Couldn't find any categories with id "+id);
			
			String name = resultSet.getString("name");
			Category category = new Category(name);
			category.setId(resultSet.getLong("id"));
			return category;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Category category) {
		try {
			String sql = "update category set name = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, category.getName());
			preparedStatement.setLong(2, category.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Category> ofBook(Long id) {
		try {
			String sql = "select distinct c.* from category c join book_category bc on bc.category_id = c.id where bc.book_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Category> categories = new ArrayList<>();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				Category category = new Category(name);
				category.setId(resultSet.getLong("id"));
				categories.add(category);
			}
			return categories;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Long id) {
		try {
			String sql = "delete from book_category where category_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			preparedStatement.execute();

			sql = "delete from category where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			preparedStatement.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
