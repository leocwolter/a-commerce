package br.com.acommerce.book;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acommerce.author.Author;
import br.com.acommerce.author.AuthorDAO;
import br.com.acommerce.category.Category;
import br.com.acommerce.category.CategoryDAO;
import br.com.acommerce.publisher.PublisherDAO;

public class BookDAO {

	private final Connection connection;
	private final CategoryDAO categories;
	private final PublisherDAO publishers;
	private final AuthorDAO authors;

	public BookDAO(Connection connection) {
		this.connection = connection;
		this.categories = new CategoryDAO(connection);
		this.publishers = new PublisherDAO(connection);
		this.authors = new AuthorDAO(connection);
	}
	
	public void save(Book book) {
		try {
			String sql = "insert into book (name, price, publisher_id, synopsis, toc, length, language) values ( ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getPrice().toPlainString());
			preparedStatement.setLong(3, book.getPublisher().getId());
			preparedStatement.setString(4, book.getSynopsis());
			preparedStatement.setString(5, book.getToc());
			preparedStatement.setInt(6, book.getLength());
			preparedStatement.setString(7, book.getLanguage());
			preparedStatement.execute();
			Long id = getLastBookId();
			book.setId(id);
			overrideCategoryRelation(book);
			overrideAuthorRelation(book);
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
				books.add(createBook(resultSet));
			}
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Book createBook(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("name");
		BigDecimal price = new BigDecimal(resultSet.getString("price"));
		Long id = resultSet.getLong("id");
		Long publisherId = resultSet.getLong("publisher_id");
		String synopsis = resultSet.getString("synopsis");
		String toc = resultSet.getString("toc");
		Integer length = resultSet.getInt("length");
		String language = resultSet.getString("language");
		
		Book book = new Book(name, categories.ofBook(id), publishers.withId(publisherId),
				price, authors.ofBook(id), synopsis, toc, length, language);
		book.setId(id);
		
		return book;
	}

	public Book withId(Long id) {
		try {
			String sql = "select * from book where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (! resultSet.next()) 
				throw new RuntimeException("Couldn't find any books with id "+id);
			return createBook(resultSet);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Book> withNameLike(String query) {
		try {
			String sql = "select * from book where name like ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+query+"%");
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Book> books = new ArrayList<>();
			while (resultSet.next()) {
				books.add(createBook(resultSet));
			}
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Book> withPublisher(Long publisherId) {
		try {
			String sql = "select * from book where publisher_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, publisherId);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Book> books = new ArrayList<>();
			while (resultSet.next()) {
				books.add(createBook(resultSet));
			}
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Book book) {
		try {
			String sql = "update book set name = ?, price = ?, authors = ?, publisher_id = ?, synopsis = ?, toc = ?, length = ?, language = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getPrice().toPlainString());
			preparedStatement.setLong(4, book.getPublisher().getId());
			preparedStatement.setString(4, book.getSynopsis());
			preparedStatement.setString(4, book.getToc());
			preparedStatement.setLong(4, book.getLength());
			preparedStatement.setString(4, book.getLanguage());
			preparedStatement.setLong(5, book.getId());
			preparedStatement.execute();
			overrideCategoryRelation(book);
			overrideAuthorRelation(book);
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

	private void overrideAuthorRelation(Book book) {
		List<Author> authors = book.getAuthors();
		removeAuthorsFrom(book.getId());
		for (Author author : authors) {
			try {
				String sql = "insert into book_author (book_id, author_id) values ( ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong(1, book.getId());
				preparedStatement.setLong(2, author.getId());
				preparedStatement.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}

	private void removeAuthorsFrom(Long id) {
		try {
			String sql = "delete from book_author where book_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
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
