package br.com.acommerce.author;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

	public List<Author> all() {
		try {
			String sql = "select * from author";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Author> authors = new ArrayList<>();
			while (resultSet.next()) {
				authors.add(createAuthor(resultSet));
			}
			return authors;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Author author) {
		try{
			String sql = "update author set name = ?, street = ?, city = ?, state = ?, country = ?, zipCode = ?, cpf = ?, complement = ?, number = ?, biography = ?, birthDay = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, author.getName());
			preparedStatement.setString(2, author.getStreet());
			preparedStatement.setString(3, author.getCity());
			preparedStatement.setString(4, author.getState());
			preparedStatement.setString(5, author.getCountry());
			preparedStatement.setString(6, author.getZipCode());
			preparedStatement.setString(7, author.getCpf());
			preparedStatement.setString(8, author.getComplement());
			preparedStatement.setInt(9, author.getNumber());
			preparedStatement.setString(10, author.getBiography());
			preparedStatement.setDate(11, new Date(author.getBirthDay().getTimeInMillis()));
			preparedStatement.setLong(12, author.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Author withId(Long id) {
		try {
			String sql = "select * from author where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (! resultSet.next()) 
				throw new RuntimeException("Couldn't find any authors with id "+id);				
			return createAuthor(resultSet);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Author createAuthor(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("name");
		Calendar birthDay = Calendar.getInstance();
		birthDay.setTime(resultSet.getDate("birthDay"));
		String biography = resultSet.getString("biography");
		String cpf = resultSet.getString("cpf");
		String street = resultSet.getString("street");
		String city = resultSet.getString("city");
		String state = resultSet.getString("state");
		String country = resultSet.getString("country");
		Integer number = resultSet.getInt("number");
		String complement =  resultSet.getString("complement");
		String zipCode =  resultSet.getString("zipCode");
		Author author = new Author(name, birthDay, biography, cpf, street, city, state, country, number, complement, zipCode);
		author.setId(resultSet.getLong("id"));
		return author;
	}
	
	public void remove(Long id) {
		try{
			String sql = "delete from book_author where author_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			preparedStatement.execute();

			sql = "delete from author where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Author> ofBook(Long id) {
		try {
			String sql = "select a.* from book_author ba join author a on a.id = ba.author_id where ba.book_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Author> authors = new ArrayList<>();
			while (resultSet.next()) {
				authors.add(createAuthor(resultSet));
			}
			return authors;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
