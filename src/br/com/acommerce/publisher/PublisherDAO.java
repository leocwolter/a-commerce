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

	public List<Publisher> all() {
		try {
			String sql = "select * from publisher";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Publisher> publishers = new ArrayList<>();
			while (resultSet.next()) {
				publishers.add(createPublisher(resultSet));
			}
			return publishers;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Publisher publisher) {
		try{
			String sql = "update publisher set name = ?, street = ?, city = ?, state = ?, country = ?, zipCode = ?, cnpj = ?, complement = ?, number = ? where id = ?";
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
			preparedStatement.setLong(10, publisher.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public Publisher withId(Long id) {
		try {
			String sql = "select * from publisher where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next())
				throw new RuntimeException("Couldn't find any publisher with id "+id);
			
			Publisher publisher = createPublisher(resultSet);
			publisher.setId(resultSet.getLong("id"));
			return publisher;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Publisher> ofBook(Long id) {
		try {
			String sql = "select distinct p.* from publisher p join book_publisher bp on bp.publisher_id = p.id where bp.book_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Publisher> publishers = new ArrayList<>();
			while (resultSet.next()) {
				Publisher publisher = createPublisher(resultSet);
				publishers.add(publisher);
			}
			return publishers;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
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

	private Publisher createPublisher(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("name");
		String street = resultSet.getString("street");
		String city = resultSet.getString("city");
		String state = resultSet.getString("state");
		String country = resultSet.getString("country");
		String zipCode = resultSet.getString("zipCode");
		String cnpj = resultSet.getString("cnpj");
		String complement = resultSet.getString("complement");
		Integer number = resultSet.getInt("number");
		Publisher publisher = new Publisher(name, street, city, state, country, zipCode, cnpj, complement, number);
		publisher.setId(resultSet.getLong("id"));
		return publisher;
	}


}
