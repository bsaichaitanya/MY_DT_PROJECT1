/*package com.niit.shoppingcart.webflow;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.niit.shoppingcart.dao.BillingAddressDAO;
import com.niit.shoppingcart.dao.CardDetailDAO;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.OrderDetailDAO;
import com.niit.shoppingcart.dao.OrderedItemsDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.ShippingAddressDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.CardDetail;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.CheckoutDetails;
import com.niit.shoppingcart.model.OrderDetail;
import com.niit.shoppingcart.model.OrderedItems;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.ShippingAddress;
import com.niit.shoppingcart.model.UserDetails;



@Component
public class FlowController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ShippingAddress shippingAddress;

	@Autowired
	private BillingAddress billingAddress;

	@Autowired
	private OrderDetail orderDetail;

	@Autowired
	private OrderedItems orderedItems;

	@Autowired
	private CardDetail cardDetail;

	@Autowired
	private ShippingAddressDAO shippingAddressDAO;

	@Autowired
	private BillingAddressDAO billingAddressDAO;

	@Autowired
	private OrderedItemsDAO orderedItemsDAO;

	@Autowired
	private OrderDetailDAO orderDetailDAO;

	@Autowired
	private CardDetailDAO cardDetailDAO;
	@Autowired
	UserDetails userDetails;
	
	@Autowired
	UserDetailsDAO  userDetailsDAO ;

	@Autowired
	CartDAO cartDAO;

	@Autowired
	List<Cart> cart;

	
	@Autowired
	HttpSession httpSession;
	@Autowired
	Product product;
	CheckoutDetails checkoutDetails = new CheckoutDetails();

	public CheckoutDetails initFlow() {
		userDetails = userDetailsDAO.get(SecurityContextHolder.getContext().getAuthentication().getName());
		checkoutDetails.setCart(cartDAO.getByUser(userDetails.getId()));
		checkoutDetails.setUserDetails(userDetailsDAO.get(userDetails.getName()));
		return checkoutDetails;
	}

	public String addShippingAddress(CheckoutDetails checkoutDetails, ShippingAddress shippingAddress) {
		userDetails = userDetailsDAO.get(SecurityContextHolder.getContext().getAuthentication().getName());

		shippingAddress.setCustomerId(userDetails.getId());
		checkoutDetails.setShippingAddress(shippingAddress);

		this.shippingAddress.setCustomerId(userDetails.getId());
		this.shippingAddress.setLine1(shippingAddress.getLine1());
		this.shippingAddress.setLine2(shippingAddress.getLine2());
		this.shippingAddress.setCity(shippingAddress.getCity());
		this.shippingAddress.setState(shippingAddress.getState());
		this.shippingAddress.setCountry(shippingAddress.getCountry());
		this.shippingAddress.setZipCode(shippingAddress.getZipCode());

		return "success";
	}

	public String addBillingAddress(CheckoutDetails checkoutDetails, BillingAddress billingAddress) {
		userDetails = userDetailsDAO.get(SecurityContextHolder.getContext().getAuthentication().getName());
		billingAddress.setCustomerId(userDetails.getId());
		checkoutDetails.setBillingAddress(billingAddress);

		this.billingAddress.setCustomerId(userDetails.getId());
		this.billingAddress.setLine1(billingAddress.getLine1());
		this.billingAddress.setLine2(billingAddress.getLine2());
		this.billingAddress.setCity(billingAddress.getCity());
		this.billingAddress.setState(billingAddress.getState());
		this.billingAddress.setCountry(billingAddress.getCountry());
		this.billingAddress.setZipCode(billingAddress.getZipCode());

		return "success";
	}

	public String addCardDetails(CheckoutDetails checkoutDetails, CardDetail cardDetail) {
		userDetails = userDetailsDAO.get(SecurityContextHolder.getContext().getAuthentication().getName());

		cardDetail.setCustomerId(userDetails.getId());
	//	cardDetail.setTotalCost(cartDAO.getByUser(userDetails.getId()).geTotal());
		cardDetailDAO.saveOrUpdate(cardDetail);

		List<Cart> listOfCartItems = cartDAO.getByUser(userDetails.getId());

		listOfCartItems = cartDAO.getByUser(userDetails.getId());

		cart = cartDAO.getByUser(userDetails.getId());

		cart.setCart_id(cart.getCart_id());
		cart.setUserID(cart.getUserID());


		shippingAddressDAO.saveOrUpdate(checkoutDetails.getShippingAddress());
		billingAddressDAO.saveOrUpdate(checkoutDetails.getBillingAddress());
		cartDAO.save(cart);


		return "success";
	}

}
*/