package br.com.acommerce.publisher;

import static java.lang.Integer.valueOf;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-publisher")
public class DeletePublisherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Connection connection = (Connection) req.getAttribute("connection");
		
		Long id = Long.valueOf(req.getParameter("id"));
		PublisherDAO publishers = new PublisherDAO(connection);
		publishers.remove(id);
		
		req.getRequestDispatcher("/WEB-INF/jsp/publisher/delete-success.jsp").forward(req, res);
	}
	
	
}
