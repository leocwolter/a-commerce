package br.com.acommerce.checkout;

import java.sql.Connection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.acommerce.cart.Cart;
import br.com.acommerce.cart.CartBean;
import br.com.acommerce.infra.ConnectionFactory;
import br.com.acommerce.user.User;
import br.com.acommerce.user.UserSessionBean;

@ManagedBean
public class CheckoutBean {

	@ManagedProperty("#{cartBean}")
	private CartBean cartBean;
	@ManagedProperty("#{userSessionBean}")
	private UserSessionBean userSessionBean;
	
	public String checkout() {
		Cart cart = cartBean.getCart();
		User user = userSessionBean.getUser();
		
		OrderDAO orders = new OrderDAO(ConnectionFactory.getConnection());
		Order order = cart.checkout(user);
		orders.save(order);
		cartBean.clean();

		return "/order/list?faces-redirect=true";
	}


	public void setCartBean(CartBean cartBean) {
		this.cartBean = cartBean;
	}
}
