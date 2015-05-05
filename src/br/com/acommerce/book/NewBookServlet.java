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

@WebServlet("/new-book")
public class NewBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");

		CategoryDAO categories = new CategoryDAO(connection);
		List<Category> categoriesList = categories.all();
		req.setAttribute("categories", categoriesList);
		req.getRequestDispatcher("/WEB-INF/jsp/book/form.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
				
		BookDAO books = new BookDAO(connection);
		CategoryDAO categories = new CategoryDAO(connection);
		
		String authors = req.getParameter("authors");
		String name = req.getParameter("name");
		BigDecimal price = new BigDecimal(req.getParameter("price"));
		
		String[] categoryIdStrings = req.getParameterValues("categories");
		List<String> categoryIds = asList(categoryIdStrings);
		List<Category> categoriesList = categoryIds.stream()
												.map(Long::valueOf)
												.map(categories::withId)
												.collect(toList());
		
		Book book = new Book(name, categoriesList, price, authors);
		books.save(book);
		
		req.setAttribute("book", book);
		req.getRequestDispatcher("/WEB-INF/jsp/book/new-success.jsp").forward(req, res);

		
	}
	
}
