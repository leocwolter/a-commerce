package br.com.acommerce.search;

import static java.lang.Integer.valueOf;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.book.BookDAO;

@WebServlet("/simple-search")
public class NewAuthorServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		
		String query = req.getParameter("q");
		BookDAO books = new BookDAO(connection);
		req.setAttribute("books", books.withNameLike(query));
		req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, res);;
	}
	
}
