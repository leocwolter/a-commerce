package br.com.acommerce.checkout;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.cart.Cart;
import br.com.acommerce.cart.CartBean;
import br.com.acommerce.user.User;
import br.com.acommerce.user.UserSessionBean;

@Named
@RequestScoped
public class CheckoutBean {

	@Inject
	private CartBean cartBean;
	@Inject
	private UserSessionBean userSessionBean;
	@Inject
	private OrderDAO orders;
	
	public String checkout() {
		Cart cart = cartBean.getCart();
		User user = userSessionBean.getUser();
		
		Order order = cart.checkout(user);
		orders.save(order);
		cartBean.clean();

		return "/order/list?faces-redirect=true";
	}


	public void setCartBean(CartBean cartBean) {
		this.cartBean = cartBean;
	}
}
