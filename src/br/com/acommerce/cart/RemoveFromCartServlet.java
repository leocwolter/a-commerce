package br.com.acommerce.cart;

import static java.lang.Long.valueOf;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.book.Book;
import br.com.acommerce.book.BookDAO;

@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		
		Long id = valueOf(req.getParameter("id"));
		BookDAO books = new BookDAO(connection);
		
		Book book = books.withId(id);
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		cart.remove(book);
		
		res.sendRedirect(req.getContextPath()+"/cart");
	}
	
}
