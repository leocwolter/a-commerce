package br.com.acommerce.infra;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.acommerce.user.User;
import br.com.acommerce.wishlist.WishListDAO;

@WebFilter("/*")
public class WishlistCreatorFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		User loggedUser = (User) request.getSession().getAttribute("loggedUser");
		if (loggedUser != null) {
			Connection connection = (Connection) req.getAttribute("connection");
			WishListDAO whishList = new WishListDAO(connection);
			req.setAttribute("wishlist", whishList.of(loggedUser));
		}
		chain.doFilter(req, res);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	
}
