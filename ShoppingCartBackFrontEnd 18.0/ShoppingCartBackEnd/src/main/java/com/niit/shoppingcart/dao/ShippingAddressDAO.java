package com.niit.shoppingcart.dao;

import com.niit.shoppingcart.model.ShippingAddress;

public interface ShippingAddressDAO {

	boolean saveOrUpdate(ShippingAddress shippingAddress);
	
	void deleteShippingAddress(String shippingAddressId);
	
	ShippingAddress getShippingAddress(String shippingAddressId);
}
