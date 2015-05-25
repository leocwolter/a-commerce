package br.com.acommerce.user;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit-user")
public class EditUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/user/form.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		UserDAO users = new UserDAO(connection);
		User user = (User) req.getSession().getAttribute("loggedUser");
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		users.update(user);
		
		req.getRequestDispatcher("/WEB-INF/jsp/user/edit-success.jsp").forward(req, res);

	}
	
}
