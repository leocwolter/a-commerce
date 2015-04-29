package br.com.acommerce.user.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.user.User;
import br.com.acommerce.user.UserDAO;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/signup/form.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		UserDAO users = new UserDAO(connection);
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = new User(email, password);
		users.save(user);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/jsp/signup/success.jsp").forward(req, res);;
	}
	
}
