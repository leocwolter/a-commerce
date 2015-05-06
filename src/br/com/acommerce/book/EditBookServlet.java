package br.com.acommerce.book;

import static java.lang.Long.valueOf;
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

@WebServlet("/edit-book")
public class EditBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");

		BookDAO books = new BookDAO(connection);
		Long id = Long.valueOf(req.getParameter("id"));
		Book book = books.withId(id);
		req.setAttribute("book", book);
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
		Long id = valueOf(req.getParameter("id"));

		Book book = new Book(name, categoriesList, price, authors);
		book.setId(id);
		books.update(book);
		
		req.setAttribute("book", book);
		req.getRequestDispatcher("/WEB-INF/jsp/book/edit-success.jsp").forward(req, res);

		
	}
	
}
