package br.com.acommerce.wishlist;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.book.Book;
import br.com.acommerce.book.BookDAO;
import br.com.acommerce.user.User;

@WebServlet("/remove-from-wishlist")
public class RemoveFromWishlistServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		BookDAO books = new BookDAO(connection);
		WishListDAO whishList = new WishListDAO(connection);

		User loggedUser = (User) req.getSession().getAttribute("loggedUser");

		Long id = Long.valueOf(req.getParameter("id"));
		Book book = books.withId(id);
		req.setAttribute("book", book);
		
		whishList.remove(book, loggedUser);
		
		req.getRequestDispatcher("/WEB-INF/jsp/wishlist/add-success.jsp").forward(req, res);
	}
	
}
