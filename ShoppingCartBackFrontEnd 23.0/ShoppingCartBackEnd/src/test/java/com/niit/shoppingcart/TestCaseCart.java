package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.BillingAddressDAO;
import com.niit.shoppingcart.dao.CardDetailDAO;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ShippingAddressDAO;
import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.CardDetail;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.ShippingAddress;


public class TestCaseCart {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	Cart cart;
	
	@Autowired
	ShippingAddress shippingAddress;
	
	@Autowired
	ShippingAddressDAO shippingAddressDAO;
	
	@Autowired
	BillingAddressDAO billingAddressDAO;
	
	@Autowired
	BillingAddress billingAddress;
	
	@Autowired
	CardDetail cardDetail;
	
	@Autowired
	CardDetailDAO cardDetailDAO;
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
	/*	cartDAO = (CartDAO)context.getBean("cartDAO");
		cart = (Cart)context.getBean("cart");*/
/*		shippingAddressDAO=(ShippingAddressDAO)context.getBean("shippingAddressDAO");
		shippingAddress=(ShippingAddress)context.getBean("shippingAddress");*/
/*		billingAddressDAO=(	BillingAddressDAO)context.getBean("billingAddressDAO");
		billingAddress=(BillingAddress)context.getBean("billingAddress");*/
		cardDetail=(CardDetail) context.getBean("cardDetail");
		cardDetailDAO=(CardDetailDAO) context.getBean("cardDetailDAO");
		
	}

	/*@Test
	public void cartTestCase(){
	//	cart.setCart_id("cart001");
		cart.setProductID("ad");
		cart.setProductName("sasdm");
		cart.setProductPrice(1234);
		cart.setQuantity(1);
		cart.setUserID("roopesh");
		cart.setTotal(133);
//	cart.setStatus("O");
		assertEquals(cartDAO.save(cart), true);
	}*/
	
/*	@Test
	public void shippingTestCase(){
	
shippingAddress.setS_line1("e");
shippingAddress.setS_line2("e");
shippingAddress.setS_city("e");
shippingAddress.setS_country("e");
shippingAddress.setS_state("e");
shippingAddress.setS_zipCode("123456");
shippingAddress.setUser_id("roopesh");

		assertEquals(shippingAddressDAO.saveOrUpdate(shippingAddress), true);
	}
*/
	
/*	@Test
	public void billingTestCase(){

	
billingAddress.setB_line1("e");
billingAddress.setB_line2("e");
billingAddress.setB_city("e");
billingAddress.setB_country("e");
billingAddress.setB_state("e");
billingAddress.setB_zipCode("123456");
billingAddress.setUser_id("roopesh");


		assertEquals(billingAddressDAO.saveOrUpdate(billingAddress), true);
	}*/
	
	@Test
	public void cardTestCase(){
cardDetail.setCardNumber(null);
cardDetail.setCvvNumber(null);
cardDetail.setExpiryMonth(null);
cardDetail.setExpiryYear(null);
cardDetail.setNameOnCard(null);
cardDetail.setUser_id(null);
cardDetail.setTotalCost(0);

		assertEquals(cardDetailDAO.saveOrUpdate(cardDetail), true);
	}

}
