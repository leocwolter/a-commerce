package br.com.acommerce.servlet.book;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.dao.BookDAO;
import br.com.acommerce.model.Book;

@WebServlet("/new-product")
public class NewBook extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/book/new-form.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Connection connection = (Connection) req.getAttribute("connection");
		BookDAO books = new BookDAO(connection);
		
		String authors = req.getParameter("authors");
		String name = req.getParameter("authors");
		String genre = req.getParameter("authors");
		BigDecimal price = new BigDecimal(req.getParameter("authors"));
		Book book = new Book(name, genre, price, authors);
		books.save(book);
		
		req.getRequestDispatcher("/WEB-INF/jsp/book/new-success.jsp").forward(req, res);

		
	}
	
}
