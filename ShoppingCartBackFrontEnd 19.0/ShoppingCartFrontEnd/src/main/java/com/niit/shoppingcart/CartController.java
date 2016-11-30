package com.niit.shoppingcart;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class CartController {
	
	Logger log=LoggerFactory.getLogger(CartController.class);
	@Autowired(required = true)
	private Cart cart;

	@Autowired
	Category category;

	@Autowired
	Product product;

	@Autowired
	UserDetails userDetails;


	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	
	@Autowired(required = true)
	private CartDAO cartDAO;

	@Autowired(required = true)
	private ProductDAO productDAO;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	@RequestMapping(value = "myCart", method = RequestMethod.GET)
	public String myCart(Model model, HttpSession session) {

		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); //get logged in username
		UserDetails userDetails=userDetailsDAO.getByUser(name);
		String loggedInUser = userDetails.getId();
		model.addAttribute("cart", new Cart());
		session.setAttribute("product", product);
		session.setAttribute("productList", this.productDAO.list());
		session.setAttribute("category", category);
		session.setAttribute("categoryList", this.categoryDAO.list());
		List<Cart> cartList = cartDAO.getByUser(loggedInUser,"N");
		model.addAttribute("cartList", cartList);
		int sum = 0;
		if (cartList != null) {
			for (int i = 0; i < cartList.size(); i++) {
				sum = sum + cartList.get(i).getTotal();
			}
			model.addAttribute("sum", sum);
		}
		model.addAttribute("userclickedcart", true);
		session.setAttribute("loggedInUser", loggedInUser);
		return "/Home";
	}

	// For add and update cart both
	@RequestMapping(value = "addtocart/{pro_id}")
	public String addToCart(@PathVariable("pro_id") String pro_id, HttpSession session, Model model) {
		log.info("////////////////// in add to cart controller");
		System.out.println(pro_id);
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); //get logged in username
		System.out.println(name);
		UserDetails userDetails=userDetailsDAO.getByUser(name);
	String loggedInUser = userDetails.getId();
	System.out.println(loggedInUser);
		Product product = productDAO.get(pro_id);
		List<Cart> cartList = cartDAO.getByUser(loggedInUser,"N");
		if (loggedInUser == null) {
			return "redirect:/login";
		} else {
			if (cartList == null) {
				int q = 1;
				cart = new Cart();
				cart.setProductID(product.getPro_id());
				cart.setProductName(product.getPro_name());
				cart.setProductPrice(product.getPro_price());
				cart.setQuantity(q);
				cart.setTotal(cart.getQuantity() * product.getPro_price());
				cart.setStatus("N");
				cart.setUserID(loggedInUser);
				boolean flag = cartDAO.save(cart);
				System.out.println(flag);
			} else {
				for (int i = 0; i < cartList.size(); i++) {
					if (product.getPro_id() == cartDAO.getByUser(loggedInUser,"N").get(i).getProductID()) {
						cart = cartList.get(i);
						cart.setQuantity(cart.getQuantity() + 1);
						cart.setTotal(cart.getQuantity() * product.getPro_price());
						cartDAO.update(cart);
						return "redirect:/Home";
					}
					else{
						int q = 1;
						cart = new Cart();
						cart.setProductID(product.getPro_id());
						cart.setProductName(product.getPro_name());
						cart.setProductPrice(product.getPro_price());
						cart.setQuantity(q);
						cart.setTotal(cart.getQuantity() * product.getPro_price());
						cart.setStatus("N");
						cart.setUserID(loggedInUser);
						boolean flag = cartDAO.save(cart);
						System.out.println(flag);
						return "redirect:/Home";
					}
				}
			}
			return "redirect:/Home";
		}
	}

	
	
	@RequestMapping(value = "/cart/remove/{cart_id}")
	public String removeCart(@PathVariable("cart_id") String cart_id, Model model) throws Exception {
		System.out.println(cart_id);
		try {
			cart = cartDAO.getCart(cart_id);
			if (cart.getQuantity() > 1) {
				cart.setQuantity(cart.getQuantity() - 1);
				cart.setTotal(cart.getQuantity() * cart.getProductPrice());
				cartDAO.update(cart);
			} else {
				cartDAO.delete(cart);
				model.addAttribute("message", "Successfully removed");
			}
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		return "redirect:/myCart";
	}
}
