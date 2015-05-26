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
		
		
		User user;
		String id = req.getParameter("id");
		if(id == null){
			user = (User) req.getSession().getAttribute("loggedUser");
		}else{
			user = users.withId(Long.valueOf(id));
		}

		users.remove(user);
		
		if(user.equals(req.getSession().getAttribute("loggedUser"))){
			res.sendRedirect(req.getContextPath()+"/logout");
		} else{
			res.sendRedirect(req.getContextPath()+"/");
		}
	}
	
}
