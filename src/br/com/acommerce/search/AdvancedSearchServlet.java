package br.com.acommerce.search;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.book.Book;
import br.com.acommerce.book.BookDAO;
import br.com.acommerce.infra.Flash;
import br.com.acommerce.infra.Errors;

@WebServlet("/advanced-search")
public class AdvancedSearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/search/form.jsp").forward(req, res);;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		String query = req.getParameter("q");
		String[] tablesAsString = req.getParameterValues("query-tables");
		if(tablesAsString == null) {
			Flash.addError("Selecione ao menos um critério de busca", req);
			res.sendRedirect(req.getContextPath()+"/advanced-search");
			return;
		}

		List<SearchableTable> tables = stream(tablesAsString)
				.map(SearchableTable::valueOf)
				.collect(toList());
		
		BookDAO books = new BookDAO(connection);
		Set<Book> booksList = books.withData(query, tables);
		
		req.setAttribute("books", booksList.stream().collect(toList()));
		req.getRequestDispatcher("/WEB-INF/jsp/search/result.jsp").forward(req, res);;
	}
	
}
