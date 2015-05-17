package br.com.acommerce.cart;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/choose-shipping")
public class ShippingServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Connection connection = (Connection) req.getAttribute("connection");
		req.setAttribute("shippingOptions", ShippingOption.values());
		
		req.getRequestDispatcher("/WEB-INF/jsp/cart/show-shipping.jsp").forward(req, res);

	}
	
}
