package br.com.acommerce.checkout;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.acommerce.cart.Cart;
import br.com.acommerce.user.User;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		OrderDAO orders = new OrderDAO(connection);
		
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		User user = (User) req.getSession().getAttribute("loggedUser");
		
		Order order = cart.checkout(user);
		orders.save(order);
		
		req.setAttribute("order", order);
		req.getRequestDispatcher("/WEB-INF/jsp/checkout/new-success.jsp").forward(req, res);

	}
	
}
