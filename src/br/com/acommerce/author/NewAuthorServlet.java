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

@WebServlet("/new-author")
public class NewAuthorServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/author/form.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Connection connection = (Connection) req.getAttribute("connection");
		AuthorDAO authors = new AuthorDAO(connection);
		
		String name = req.getParameter("name");
		
		String dateString = req.getParameter("birthDay");
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
			Calendar birthDay = Calendar.getInstance();
			birthDay.setTime(date);
		
			String biography = req.getParameter("biography");
			String cpf = req.getParameter("cpf");
			String street = req.getParameter("street");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String country = req.getParameter("country");
			Integer number = valueOf(req.getParameter("number"));
			String complement = req.getParameter("complement");
			String zipCode = req.getParameter("zipCode");
			
			Author author = new Author(name, birthDay, biography, cpf, street, city, state, country, number, complement, zipCode);
			authors.save(author);
			
			req.setAttribute("author", author);
			req.getRequestDispatcher("/WEB-INF/jsp/author/new-success.jsp").forward(req, res);
		} catch (ParseException e) {
			throw new RuntimeException("Could'nt format date "+dateString, e);
		}

		
	}
	
}
