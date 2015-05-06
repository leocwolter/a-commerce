package br.com.acommerce.book;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.category.Category;
import br.com.acommerce.category.CategoryDAO;

@WebServlet("/delete-book")
public class DeleteBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
				
		BookDAO books = new BookDAO(connection);
		
		Long id = Long.valueOf(req.getParameter("id"));
		books.remove(id);
		
		req.getRequestDispatcher("/WEB-INF/jsp/book/delete-success.jsp").forward(req, res);

		
	}
	
}
