package br.com.acommerce.book;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acommerce.category.Category;
import br.com.acommerce.category.CategoryDAO;
import br.com.acommerce.publisher.PublisherDAO;

public class BookDAO {

	private final Connection connection;
	private final CategoryDAO categories;
	private final PublisherDAO publishers;

	public BookDAO(Connection connection) {
		this.connection = connection;
		this.categories = new CategoryDAO(connection);
		this.publishers = new PublisherDAO(connection);
	}

	public void save(Book book) {
		try {
			String sql = "insert into book (name, price, authors, publisher_id) values ( ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getPrice().toPlainString());
			preparedStatement.setString(3, book.getAuthors());
			preparedStatement.setLong(4, book.getPublisher().getId());
			preparedStatement.execute();
			Long id = getLastBookId();
			book.setId(id);
			overrideCategoryRelation(book);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Book> all() {
		try {
			String sql = "select * from book";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Book> books = new ArrayList<>();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				BigDecimal price = new BigDecimal(resultSet.getString("price"));
				String authors = resultSet.getString("authors");
				Long id = resultSet.getLong("id");
				
				Book book = new Book(name, categories.ofBook(id), publishers.withId(id), price, authors);
				book.setId(id);
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Book withId(Long id) {
		try {
			String sql = "select * from book where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (! resultSet.next()) 
				throw new RuntimeException("Couldn't find any books with id "+id);
			
			String name = resultSet.getString("name");
			BigDecimal price = new BigDecimal(resultSet.getString("price"));
			String authors = resultSet.getString("authors");
			Long publisherId = resultSet.getLong("publisher_id");
			
			Book book = new Book(name, categories.ofBook(id),  publishers.withId(publisherId), price, authors);
			book.setId(id);
			return book;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Book book) {
		try {
			String sql = "update book set name = ?, price = ?, authors = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getPrice().toPlainString());
			preparedStatement.setString(3, book.getAuthors());
			preparedStatement.setLong(4, book.getId());
			preparedStatement.execute();
			overrideCategoryRelation(book);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Long id) {
		try {
			removeCategoriesFrom(id);
			String sql = "delete from book where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Long getLastBookId() {
		try {
			String sql = "select id from book order by id desc limit 1";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) 
				throw new RuntimeException("The database is empty. Create new books to solve this");
			return resultSet.getLong("id");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void overrideCategoryRelation(Book book) {
		List<Category> categories = book.getCategories();
		removeCategoriesFrom(book.getId());
		for (Category category : categories) {
			try {
				String sql = "insert into book_category (book_id, category_id) values ( ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong(1, book.getId());
				preparedStatement.setLong(2, category.getId());
				preparedStatement.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	private void removeCategoriesFrom(Long id) {
		try {
			String sql = "delete from book_category where book_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
