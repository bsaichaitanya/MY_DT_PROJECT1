package com.niit.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class CartController {

	Logger log = LoggerFactory.getLogger(CartController.class);
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
		String name = auth.getName(); // get logged in username
		UserDetails userDetails = userDetailsDAO.getByUser(name);
		String loggedInUser = userDetails.getId();
		model.addAttribute("cart", new Cart());
		session.setAttribute("product", product);
		session.setAttribute("productList", this.productDAO.list());
		session.setAttribute("category", category);
		session.setAttribute("categoryList", this.categoryDAO.list());
		List<Cart> cartList = cartDAO.getByUser(loggedInUser, "N");
		if (cartList != null) {
			for (int i = 0; i < cartList.size(); i++) {
				if (cartList.get(i).getProduct().getPro_quantity() == 0) {
					cartList.get(i).getProduct().setOutOfStock(true);
					productDAO.update(cartList.get(i).getProduct());
					log.debug("///////////setting cart quantity status/////////////////////"
							+ cartList.get(i).getProduct().isOutOfStock());
				}
			}
		}
		model.addAttribute("cartList", cartList);
		int sum = 0;
		if (cartList != null) {

			for (int i = 0; i < cartList.size(); i++) {
				if (cartList.get(i).getProduct().isOutOfStock() == false) {
					sum = sum + cartList.get(i).getTotal();
				}
			}
			model.addAttribute("sum", sum);
		}
		model.addAttribute("userclickedcart", true);
		session.setAttribute("loggedInUser", loggedInUser);
		return "/Home";
	}

	@RequestMapping(value = "addtocart/{pro_id}")
	public String addToCart(@PathVariable("pro_id") String pro_id, HttpSession session, Model model,
			RedirectAttributes redirectAttributes) {
		log.info("////////////////// in add to cart controller///////////////////////////////////////");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		if (name == "anonymousUser") {
			return "redirect:/login";
		}
		UserDetails userDetails = userDetailsDAO.getByUser(name);
		String loggedInUser = userDetails.getId();
		Product product = productDAO.get(pro_id);
		if (product.getPro_quantity() == 0) {
			// if product is out of stock
			// return product is not available
			redirectAttributes.addFlashAttribute("OutOfStock", "true");
			System.out.println(pro_id);
			return "redirect:/p/" + pro_id;
		}
		List<Cart> cartList = cartDAO.getByUser(loggedInUser, "N");
		if (cartList == null) {
			log.info(
					"////////////////////////////////cart list is empty, add product/////////////////////////////////////////////");
			// if cart table is null
			// add the product in your cart
			int q = 1;
			cart = new Cart();
			cart.setProductID(product.getPro_id());
			cart.setQuantity(q);
			cart.setTotal(cart.getQuantity() * product.getPro_price());
			cart.setStatus("N");
			cart.setUserID(loggedInUser);
			cartDAO.save(cart);
		}

		if (cartList != null) {
			// if cart is not empty
			// check wheather there exist same product in cart
			// if exists , check if product quantity in cart is less than
			// available quantity
			// increase the quantity
			// return you cannot add the product
			boolean found = false;
			for (Cart cartCheck : cartList) {
				if (product.getPro_id() == cartCheck.getProductID()) {
					cart=cartCheck;
					found = true;					
					break;
				} else {
					found = false;	
				}
			}
			if(found == true){
				if (cart.getQuantity() < cart.getProduct().getPro_quantity()) {
					log.info(
							"//////////////////////////////// increase quantity/////////////////////////////////////////");
					cart.setQuantity(cart.getQuantity() + 1);
					cart.setTotal(cart.getQuantity() * cart.getProduct().getPro_price());
					cartDAO.update(cart);
				} else {
					log.info(
							"////////////////////////////////product went out of stock/////////////////////////////////////////");
					redirectAttributes.addFlashAttribute("productOutOfStock", "true");
					String proID = cart.getProductID();
					System.out.println(proID);	
					return "redirect:/p/"+proID;
				}
			}
			else{
				int q = 1;
				log.info(
						"/////////////////////////////////////product is not available in cart, add the product in your cart///////////////////////");
				cart = new Cart();
				cart.setProductID(product.getPro_id());
				cart.setQuantity(q);
				cart.setTotal(cart.getQuantity() * product.getPro_price());
				cart.setStatus("N");
				cart.setUserID(loggedInUser);
				cartDAO.save(cart);
			}
		}
		return "redirect:/Home";
	}

	@RequestMapping(value = "/cart/remove/{cart_id}")
	public String removeCart(@PathVariable("cart_id") String cart_id, Model model) throws Exception {
		// to remove a product
		System.out.println(cart_id);
		try {
			cart = cartDAO.getCart(cart_id);
			String prodID = cart.getProductID();
			Product product = productDAO.get(prodID);
			if (cart.getQuantity() > 1) {
				// if product is multiple in number
				// decrease the quantity
				cart.setQuantity(cart.getQuantity() - 1);
				cart.setTotal(cart.getQuantity() * product.getPro_price());
				cartDAO.update(cart);
			} else {
				// if there is only one product
				// remove the product
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
