package br.com.acommerce.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

@RequestScoped
public class ConnectionFactory {

	@Produces
	@RequestScoped
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/acommerce", "root", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void destroy(@Disposes Connection connection) throws SQLException{
		connection.close();
	}
}
