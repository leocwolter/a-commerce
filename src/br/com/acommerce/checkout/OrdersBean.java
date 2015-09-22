package br.com.acommerce.checkout;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.acommerce.user.User;
import br.com.acommerce.user.UserSessionBean;

@Named
@RequestScoped
public class OrdersBean {
	
	@Inject
	private UserSessionBean userSessionBean;
	@Inject
	private OrderDAO orders;
	
	public List<Order> getList() {
		User user = userSessionBean.getUser();
		return orders.withOwner(user);
	}
	
	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}
}
