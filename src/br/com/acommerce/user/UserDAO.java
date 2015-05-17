package br.com.acommerce.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.acommerce.checkout.OrderDAO;

public class UserDAO {
	
	private Connection connection;

	public UserDAO(Connection connection) {
		this.connection = connection;
	}

	
	public User getWithEmailAndPassword(String email, String password) {
		try {
			String sql = "select * from user where email = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				User user = createUser(resultSet);
				return user;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public void save(User user) {
		try {
			String sql = "insert into user (email, password) values ( ? , ? )";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void update(User user) {
		try {
			String sql = "update user set email = ?, password = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setLong(3, user.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void remove(User user) {
		try {
			String sql = "delete from user where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			OrderDAO orders = new OrderDAO(connection);
			orders.removeWithOwner(user);
			preparedStatement.setLong(1, user.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public User withId(long id) {
		try {
			String sql = "select * from user where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				User user = createUser(resultSet);
				return user;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private User createUser(ResultSet resultSet) throws SQLException {
		String userEmail = resultSet.getString("email");
		String userPassword = resultSet.getString("password");
		User user = new User(userEmail, userPassword);
		user.setAdmin(resultSet.getBoolean("admin"));
		user.setId(resultSet.getLong("id"));
		return user;
	}

}
