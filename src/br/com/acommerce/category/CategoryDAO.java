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
				categories.add(new Category(name));
			}
			return categories;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
