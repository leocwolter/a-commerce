package br.com.acommerce.publisher;

import static java.lang.Integer.valueOf;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit-publisher")
public class EditPublisherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Connection connection = (Connection) req.getAttribute("connection");
		PublisherDAO publishers = new PublisherDAO(connection);
		
		Long id = Long.valueOf(req.getParameter("id"));
		req.setAttribute("publisher", publishers.withId(id));
		
		req.getRequestDispatcher("/WEB-INF/jsp/publisher/form.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Connection connection = (Connection) req.getAttribute("connection");
		PublisherDAO publishers = new PublisherDAO(connection);
		
		String name = req.getParameter("name");
		String street = req.getParameter("street");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		String zipCode = req.getParameter("zipCode");
		String cnpj = req.getParameter("cnpj");
		String complement = req.getParameter("complement");
		Integer number = valueOf(req.getParameter("number"));
		Long id = Long.valueOf(req.getParameter("id"));
		Publisher publisher = new Publisher(name, street, city, state, country, zipCode, cnpj, complement, number);
		publisher.setId(id);
		publishers.update(publisher);
		
		req.setAttribute("publisher", publisher);
		req.getRequestDispatcher("/WEB-INF/jsp/publisher/edit-success.jsp").forward(req, res);

		
	}
	
}
