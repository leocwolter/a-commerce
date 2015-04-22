package br.com.acommerce.servlet.user;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.dao.UserDAO;
import br.com.acommerce.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/login/form.jsp").forward(req, res);;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		UserDAO users = new UserDAO(connection);
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User userToLogIn = users.getWithEmailAndPassword(email, password);
		req.getSession().setAttribute("loggedUser", userToLogIn);
		
		req.getRequestDispatcher("/WEB-INF/jsp/login/success.jsp").forward(req, res);;

	}
}
