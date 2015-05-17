package br.com.acommerce.checkout;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.acommerce.user.User;

public class OrderDAO {

	private Connection connection;

	public OrderDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void save(Order order) {
		try {
			String sql = "insert into `order` (owner_id, creationDate, shippingOption) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, order.getOwner().getId());
			preparedStatement.setDate(2, new Date(order.getCreationDate().getTimeInMillis()));
			preparedStatement.setString(3, order.getShippingOption().name());
			preparedStatement.execute();
			order.setId(getLastOrderId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		saveItems(order.getOrderedBooks());
	}

	private void saveItems(List<OrderedBook> orderedBooks) {
		for (OrderedBook orderedBook : orderedBooks) {
			try {
				String sql = "insert into ordered_book (book_id, quantity, order_id) values (?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong(1, orderedBook.getBook().getId());
				preparedStatement.setLong(2, orderedBook.getQuantity());
				preparedStatement.setLong(3, orderedBook.getOrder().getId());
				preparedStatement.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}		
		} 
	}

	private Long getLastOrderId() {
		try {
			String sql = "select id from `order` order by id desc limit 1";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) 
				throw new RuntimeException("The database is empty. Create an order to solve this");
			return resultSet.getLong("id");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
