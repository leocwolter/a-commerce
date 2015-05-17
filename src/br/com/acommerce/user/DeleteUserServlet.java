package br.com.acommerce.user;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-user")
public class DeleteUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Connection connection = (Connection) req.getAttribute("connection");
		UserDAO users = new UserDAO(connection);
		User loggedUser = (User) req.getSession().getAttribute("loggedUser");
		users.remove(loggedUser);
		
		res.sendRedirect(req.getContextPath()+"/logout");
	}
	
}
