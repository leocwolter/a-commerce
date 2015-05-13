package br.com.acommerce.author;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-category")
public class DeleteCategoryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		CategoryDAO categories = new CategoryDAO(connection);
		
		Long id = Long.valueOf(req.getParameter("id"));
		categories.remove(id);
		
		req.getRequestDispatcher("/WEB-INF/jsp/category/delete-success.jsp").forward(req, res);
	}
	
	
}
