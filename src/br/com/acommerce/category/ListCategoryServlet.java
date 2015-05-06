package br.com.acommerce.category;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/categories")
public class ListCategoryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		CategoryDAO categories = new CategoryDAO(connection);
		req.setAttribute("categories", categories.all());
		req.getRequestDispatcher("/WEB-INF/jsp/category/list.jsp").forward(req, res);
	}
	
	
}
