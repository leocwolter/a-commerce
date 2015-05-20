package br.com.acommerce.checkout;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.acommerce.book.Book;
import br.com.acommerce.book.BookDAO;
import br.com.acommerce.cart.ShippingOption;
import br.com.acommerce.user.User;
import br.com.acommerce.user.UserDAO;

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
			preparedStatement.setTimestamp(2, new Timestamp(order.getCreationDate().getTimeInMillis()));
			preparedStatement.setString(3, order.getShippingOption().name());
			preparedStatement.execute();
			order.setId(getLastOrderId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		saveItems(order.getOrderedBooks());
	}

	public List<Order> withOwner(User user) {
		try {
			String sql = "select * from `order` where owner_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, user.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Order> orders = new ArrayList<>();
			while(resultSet.next()){
				Order order = createOrder(resultSet);
				orders.add(order);
			}
			return orders;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Order createOrder(ResultSet resultSet) throws SQLException {
		ShippingOption option = ShippingOption.valueOf(resultSet.getString("shippingOption"));
		long id = resultSet.getLong("id");
		UserDAO users = new UserDAO(connection);
		Order order = new Order(orderedBooksOfOrder(id), users.withId(resultSet.getLong("owner_id")), option);
		Timestamp timestamp = resultSet.getTimestamp("creationDate");
		Calendar creationDate = Calendar.getInstance();
		creationDate.setTimeInMillis(timestamp.getTime());
		order.setCreationDate(creationDate);
		order.setId(id);
		return order;
	}

	private List<OrderedBook> orderedBooksOfOrder(long orderId) {
		try {
			String sql = "select * from `ordered_book` where order_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<OrderedBook> orderedBooks = new ArrayList<>();
			BookDAO books = new BookDAO(connection);
			while(resultSet.next()){
				long bookId = resultSet.getLong("book_id");
				Book book = books.withId(bookId);
				long quantity = resultSet.getLong("quantity");
				BigDecimal price = new BigDecimal(resultSet.getString("price"));
				orderedBooks.add(new OrderedBook(book, quantity, price));
			}
			return orderedBooks;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void saveItems(List<OrderedBook> orderedBooks) {
		for (OrderedBook orderedBook : orderedBooks) {
			try {
				String sql = "insert into ordered_book (book_id, quantity, order_id, price) values (?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong(1, orderedBook.getBook().getId());
				preparedStatement.setLong(2, orderedBook.getQuantity());
				preparedStatement.setLong(3, orderedBook.getOrder().getId());
				preparedStatement.setString(4, orderedBook.getPrice().toPlainString());
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

	public void removeWithOwner(User user) {
		List<Order> orders = withOwner(user);
		for (Order order : orders) {
			removeOrderedBooksOf(order);
			try {
				String sql = "delete from `order` where id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong(1, order.getId());
				preparedStatement.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	

	public void removeWithBook(Long id) {
		List<Order> orders = withBook(id);
		for (Order order : orders) {
			removeOrderedBooksOf(order);
			try {
				String sql = "delete from `order` where id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong(1, order.getId());
				preparedStatement.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}


	private List<Order> withBook(Long bookId) {
		try {
			String sql = "select * from `order` o join ordered_book ob on ob.order_id = o.id where ob.book_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, bookId);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Order> orders = new ArrayList<>();
			while(resultSet.next()){
				Order order = createOrder(resultSet);
				orders.add(order);
			}
			return orders;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void removeOrderedBooksOf(Order order) {
		try {
			String sql = "delete from `ordered_book` where order_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, order.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
