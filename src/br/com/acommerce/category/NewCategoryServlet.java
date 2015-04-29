package br.com.acommerce.category;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/new-category")
public class NewCategoryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/category/new-form.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Connection connection = (Connection) req.getAttribute("connection");
		CategoryDAO categories = new CategoryDAO(connection);
		
		String name = req.getParameter("name");
		Category category = new Category(name);
		categories.save(category);
		
		req.setAttribute("category", category);
		req.getRequestDispatcher("/WEB-INF/jsp/category/new-success.jsp").forward(req, res);

		
	}
	
}
