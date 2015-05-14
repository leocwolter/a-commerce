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

import br.com.acommerce.author.Author;
import br.com.acommerce.author.AuthorDAO;
import br.com.acommerce.category.Category;
import br.com.acommerce.category.CategoryDAO;
import br.com.acommerce.publisher.Publisher;
import br.com.acommerce.publisher.PublisherDAO;

@WebServlet("/new-book")
public class NewBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");

		CategoryDAO categories = new CategoryDAO(connection);
		List<Category> categoriesList = categories.all();
		req.setAttribute("categories", categoriesList);

		PublisherDAO publishers = new PublisherDAO(connection);
		List<Publisher> publisherList = publishers.all();
		req.setAttribute("publishers", publisherList);

		AuthorDAO authors = new AuthorDAO(connection);
		List<Author> authorList = authors.all();
		req.setAttribute("authors", authorList);

		req.getRequestDispatcher("/WEB-INF/jsp/book/form.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
				
		BookDAO books = new BookDAO(connection);
		CategoryDAO categories = new CategoryDAO(connection);
		PublisherDAO publishers = new PublisherDAO(connection);
		AuthorDAO authors = new AuthorDAO(connection);
		
		String name = req.getParameter("name");
		BigDecimal price = new BigDecimal(req.getParameter("price"));
		
		String[] categoryIdStrings = req.getParameterValues("categories");
		List<String> categoryIds = asList(categoryIdStrings);
		List<Category> categoriesList = categoryIds.stream()
												.map(Long::valueOf)
												.map(categories::withId)
												.collect(toList());
		
		String[] authorIdStrings = req.getParameterValues("authors");
		List<String> authorIds = asList(authorIdStrings);
		List<Author> authorList = authorIds.stream()
												.map(Long::valueOf)
												.map(authors::withId)
												.collect(toList());

		Long publisherId = valueOf(req.getParameter("publisher"));
		
		Book book = new Book(name, categoriesList, publishers.withId(publisherId), price, authorList);
		books.save(book);
		
		req.setAttribute("book", book);
		req.getRequestDispatcher("/WEB-INF/jsp/book/new-success.jsp").forward(req, res);

		
	}
	
}
