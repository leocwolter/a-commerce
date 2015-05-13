package br.com.acommerce.author;

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

@WebServlet("/authors")
public class ListAuthorServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		AuthorDAO authors = new AuthorDAO(connection);
		req.setAttribute("authors", authors.all());
		
		req.getRequestDispatcher("/WEB-INF/jsp/author/list.jsp").forward(req, res);
	}
	
	
}
