package com.niit.shoppingcart.model;

import java.io.Serializable;

public class CheckoutDetails implements Serializable {
	private CardDetail cardDetail;
	private ShippingAddress shippingAddress;
	private BillingAddress billingAddress;
	private OrderDetail orderDetail;
	private OrderedItems orderedItems;
	private Cart cart;
	private UserDetails userDetails;
	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	

	public CardDetail getCardDetail() {
		return cardDetail;
	}

	public void setCardDetail(CardDetail cardDetail) {
		this.cardDetail = cardDetail;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public OrderedItems getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(OrderedItems orderedItems) {
		this.orderedItems = orderedItems;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}



}
