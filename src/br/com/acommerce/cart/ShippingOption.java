package br.com.acommerce.cart;

import java.math.BigDecimal;

public enum ShippingOption {
	SEDEX("22.50"),
	ESEDEX("16.50");

	private final BigDecimal price;

	private ShippingOption(String price) {
		this.price = new BigDecimal(price);
	}
	
	public BigDecimal getPrice() {
		return price;
	}
}
