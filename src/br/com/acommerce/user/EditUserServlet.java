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
		Connection connection = (Connection) req.getAttribute("connection");
		UserDAO users = new UserDAO(connection);
		String id = req.getParameter("id");
		if(id != null){
			User user = users.withId(Long.valueOf(id));
			req.setAttribute("user", user);
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/user/edit-form.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		UserDAO users = new UserDAO(connection);
		
		User user;
		String id = req.getParameter("id");
		if(id == null){
			user = (User) req.getSession().getAttribute("loggedUser");
		}else{
			user = users.withId(Long.valueOf(id));
		}
		
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		users.update(user);
		
		req.getRequestDispatcher("/WEB-INF/jsp/user/edit-success.jsp").forward(req, res);

	}
	
}
