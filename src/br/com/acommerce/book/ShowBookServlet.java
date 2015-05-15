package br.com.acommerce.book;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class ShowBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");

		BookDAO books = new BookDAO(connection);
		Long id = Long.valueOf(req.getParameter("id"));
		req.setAttribute("book", books.withId(id));

		req.getRequestDispatcher("/WEB-INF/jsp/book/show.jsp").forward(req, res);
	}
	
}
