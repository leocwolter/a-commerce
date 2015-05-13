package br.com.acommerce.publisher;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/publishers")
public class ListPublisherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		PublisherDAO publishers = new PublisherDAO(connection);
		req.setAttribute("publishers", publishers.all());
		req.getRequestDispatcher("/WEB-INF/jsp/publisher/list.jsp").forward(req, res);
	}
	
	
}
