package br.com.acommerce.category;

import static java.lang.Long.valueOf;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit-category")
public class EditCategoryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		CategoryDAO categories = new CategoryDAO(connection);
		Category category = categories.withId(valueOf(req.getParameter("id")));
		req.setAttribute("category", category);
		req.getRequestDispatcher("/WEB-INF/jsp/category/form.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Connection connection = (Connection) req.getAttribute("connection");
		CategoryDAO categories = new CategoryDAO(connection);
		Category category = categories.withId(valueOf(req.getParameter("id")));
		
		String name = req.getParameter("name");
		category.setName(name);
		categories.update(category);
		
		req.setAttribute("category", category);
		req.getRequestDispatcher("/WEB-INF/jsp/category/edit-success.jsp").forward(req, res);

		
	}
	
}
