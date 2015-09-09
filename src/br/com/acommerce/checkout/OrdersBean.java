package br.com.acommerce.checkout;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.acommerce.infra.ConnectionFactory;
import br.com.acommerce.user.User;
import br.com.acommerce.user.UserSessionBean;

@ManagedBean
public class OrdersBean {
	
	@ManagedProperty("#{userSessionBean}")
	private UserSessionBean userSessionBean;
	
	public List<Order> list() {
		OrderDAO orders = new OrderDAO(ConnectionFactory.getConnection());
		
		User user = userSessionBean.getUser();
		return orders.withOwner(user);
	}
	
	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}
}
