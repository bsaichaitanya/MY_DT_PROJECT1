package com.niit.shoppingcart;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;


public class TestCaseCart {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	Cart cart;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDAO = (CartDAO)context.getBean("cartDAO");
		cart = (Cart)context.getBean("cart");
	}

	@Test
	public void cartTestCase(){
	//	cart.setCart_id("cart001");
		cart.setProductID("ad");
		cart.setProductName("sasdm");
		cart.setProductPrice("1d00");
		cart.setQuantity(1);
	cart.setUserID("roopesh");
		assertEquals(cartDAO.save(cart), true);
	}


}
