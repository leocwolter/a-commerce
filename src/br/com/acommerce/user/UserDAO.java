package br.com.acommerce.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				String userEmail = resultSet.getString("email");
				String userPassword = resultSet.getString("password");
				return new User(userEmail, userPassword);
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

}