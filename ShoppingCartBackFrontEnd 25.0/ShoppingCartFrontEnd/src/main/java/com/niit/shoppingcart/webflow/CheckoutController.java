package com.niit.shoppingcart.webflow;

import java.util.List;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.niit.shoppingcart.dao.BillingAddressDAO;
import com.niit.shoppingcart.dao.CardDetailDAO;
import com.niit.shoppingcart.dao.CartDAO;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.ShippingAddressDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.CardDetail;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.ShippingAddress;
import com.niit.shoppingcart.model.UserDetails;



@Component
public class CheckoutController {
	Logger log=LoggerFactory.getLogger(CheckoutController.class);
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ShippingAddress shippingAddress;

	@Autowired
	private BillingAddress billingAddress;


	@Autowired
	private CardDetail cardDetail;

	@Autowired
	private ShippingAddressDAO shippingAddressDAO;

	@Autowired
	private BillingAddressDAO billingAddressDAO;

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
	
	
	public ShippingAddress initFlow() {
		
		return new ShippingAddress();
	}

	public String saveDetails(ShippingAddress shippingAddress){
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
			UserDetails userDetails=userDetailsDAO.getByUser(name);
			String loggedInUser = userDetails.getId();
	      shippingAddress.setUser_id(loggedInUser);
		shippingAddressDAO.saveOrUpdate(shippingAddress);

		return "success";
	}
	public String saveDetails(BillingAddress billingAddress){
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
			UserDetails userDetails=userDetailsDAO.getByUser(name);
			String loggedInUser = userDetails.getId();
	      billingAddress.setUser_id(loggedInUser);
		billingAddressDAO.saveOrUpdate(billingAddress);
		return "success";
	}
	public String saveDetails(CardDetail cardDetail){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
			UserDetails userDetails=userDetailsDAO.getByUser(name);
			String loggedInUser = userDetails.getId();
	      cardDetail.setUser_id(loggedInUser);
		cardDetailDAO.saveOrUpdate(cardDetail);
		return "success";	
	}
	
	
	public String remove(){
		System.out.println("/////////////remove/////////////////");
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
			UserDetails userDetails=userDetailsDAO.getByUser(name);
			String loggedInUser = userDetails.getId();
			List<Cart> cartList = cartDAO.getByUser(loggedInUser,"N");
			if (cartList != null) {
				for (int i = 0; i < cartList.size(); i++) {
				String p_id=cartList.get(i).getProductID();
				Product product=productDAO.get(p_id);
				product.setPro_quantity(product.getPro_quantity()-cartList.get(i).getQuantity());
				productDAO.update(product);
				cartList.get(i).setStatus("O");
				cartDAO.update(cartList.get(i));
				}	
			}
			return "success";
	
}
}
