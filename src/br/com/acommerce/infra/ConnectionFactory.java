package br.com.acommerce.infra;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@RequestScoped
public class ConnectionFactory {


	@Resource(name="jdbc/acommerce")
	private DataSource dataSource;
	
	@Produces
	@RequestScoped
	public Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
