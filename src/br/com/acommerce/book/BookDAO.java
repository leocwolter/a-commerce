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

public class BookDAO {

	private final Connection connection;
	private final CategoryDAO categories ;

	public BookDAO(Connection connection) {
		this.connection = connection;
		this.categories = new CategoryDAO(connection);
	}

	public void save(Book book) {
		try {
			String sql = "insert into book (name, price, authors) values ( ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getPrice().toPlainString());
			preparedStatement.setString(3, book.getAuthors());
			preparedStatement.execute();
			Long id = getLastBookId();
			book.setId(id);
			saveCategoryRelation(book);
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

	private void saveCategoryRelation(Book book) {
		List<Category> categories = book.getCategories();
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
				
				Book book = new Book(name, categories.ofBook(id), price, authors);
				book.setId(id);
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
