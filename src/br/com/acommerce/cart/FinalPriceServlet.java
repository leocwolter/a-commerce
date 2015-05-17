package br.com.acommerce.cart;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show-final-price")
public class FinalPriceServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		String shippingOptionAsString = req.getParameter("shipping-option");
		ShippingOption shippingOption = ShippingOption.valueOf(shippingOptionAsString);
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		cart.setShippingOption(shippingOption);
		req.getRequestDispatcher("/WEB-INF/jsp/cart/show-final-price.jsp").forward(req, res);

	}
	
}
