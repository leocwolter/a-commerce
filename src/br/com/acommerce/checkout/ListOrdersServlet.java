package br.com.acommerce.checkout;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.user.User;

@WebServlet("/my-orders")
public class ListOrdersServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		OrderDAO orders = new OrderDAO(connection);
		
		User user = (User) req.getSession().getAttribute("loggedUser");
		req.setAttribute("orders", orders.withOwner(user));
		req.getSession().setAttribute("cart", null);
		
		req.getRequestDispatcher("/WEB-INF/jsp/order/list.jsp").forward(req, res);

	}
	
}
