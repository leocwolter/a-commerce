package br.com.acommerce.cart;

import static java.lang.Long.valueOf;
import static java.util.Arrays.asList;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.book.Book;
import br.com.acommerce.book.BookDAO;

@WebServlet("/cart")
public class ShowCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		req.getRequestDispatcher("/WEB-INF/jsp/cart/show.jsp").forward(req, res);
	}
	
}
