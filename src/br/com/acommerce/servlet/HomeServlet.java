package br.com.acommerce.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.dao.BookDAO;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		BookDAO books = new BookDAO(connection);
		req.setAttribute("books", books.all());
		req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, res);;
	}
	
}
