package br.com.acommerce.wishlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.acommerce.book.Book;
import br.com.acommerce.book.BookDAO;
import br.com.acommerce.user.User;

@RequestScoped
public class WishListDAO {

	@Inject
	private Connection connection;
	@Inject
	private BookDAO books;

	public void add(Book book, User user) {
		try {
			String sql = "insert into wishlisted_book (book_id, user_id) values (?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, book.getId());
			preparedStatement.setLong(2, user.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}

	public List<Book> of(User loggedUser) {
		try {
			String sql = "select * from wishlisted_book where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, loggedUser.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Book> wishlistedBooks = new ArrayList<>();
			while(resultSet.next()){
				wishlistedBooks.add(books.withId(resultSet.getLong("book_id")));
			}
			return wishlistedBooks;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Book book, User loggedUser) {
		try {
			String sql = "delete from wishlisted_book where user_id = ? and book_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, loggedUser.getId());
			preparedStatement.setLong(2, book.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Book book) {
		try {
			String sql = "delete from wishlisted_book where book_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, book.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void removeWithOwner(User user) {
		try {
			String sql = "delete from wishlisted_book where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, user.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
