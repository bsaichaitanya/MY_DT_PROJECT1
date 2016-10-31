package com.niit.shoppingcart;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class CartController {
	@Autowired(required = true)
	private Cart cart;

	@Autowired
	Category category;
	
	@Autowired
	Product product;
	
	@Autowired
	UserDetails userDetails;

	@Autowired(required = true)
	private CartDAO cartDAO;

	@Autowired(required = true)
	private ProductDAO productDAO;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	
	@RequestMapping(value = "myCart", method = RequestMethod.GET)
	public String myCart(Model model, HttpSession session) {

		String loggedInUser=(String) session.getAttribute("loggedInUserID");
		model.addAttribute("cart", new Cart());
		model.addAttribute("product", product);
		model.addAttribute("productList",this.productDAO.list());
		model.addAttribute("category", category);
		model.addAttribute("categoryList",this.categoryDAO.list());
		List<Cart> cartList=cartDAO.getByUser(loggedInUser);
		
		model.addAttribute("cartList", cartList);
	int sum=0;
		for(int i=0;i<cartList.size();i++){
			 sum=sum+cartList.get(i).getTotal();
		}
		model.addAttribute("sum",sum);
		model.addAttribute("userclickedcart", true);
		
		return "/Home";
		
	}

	// For add and update cart both
	@RequestMapping(value = "addtocart/{pro_id}")
	public String addToCart(@PathVariable("pro_id") String pro_id,HttpSession session,Model model){
	
		System.out.println(pro_id);
		String loggedInUser=(String) session.getAttribute("loggedInUserID");
		Product product = productDAO.get(pro_id);
		List<Cart> cartList=cartDAO.getByUser(loggedInUser);
		if(loggedInUser==null){
			return "redirect:/Login";
		}
		else{
			for(int i=0;i<cartList.size();i++){
			if(product.getPro_id()==cartDAO.getByUser(loggedInUser).get(i).getProductID()){
				cart=cartList.get(i);
				cart.setQuantity(cart.getQuantity()+1);
				cart.setTotal(cart.getQuantity()*product.getPro_price());
				cartDAO.update(cart);
				return "redirect:/";
			}
			}
			int q = 1;
			cart= new Cart();
			cart.setProductID(product.getPro_id());
			cart.setProductName(product.getPro_name());
			cart.setProductPrice(product.getPro_price());
			cart.setQuantity(q);
			cart.setTotal(cart.getQuantity()*product.getPro_price());
			cart.setUserID(loggedInUser);
			boolean flag=cartDAO.save(cart);
			System.out.println(flag); 
		return "redirect:/";
		}
	}

	
	@RequestMapping(value = "/cart/remove/{cart_id}")
	public String removeCart(@PathVariable("cart_id") String cart_id, Model model) throws Exception {
		System.out.println(cart_id);
		try {
			cart=cartDAO.getCart(cart_id);
			if(cart.getQuantity()>1){
				cart.setQuantity(cart.getQuantity()-1);
				cart.setTotal(cart.getQuantity()*cart.getProductPrice());
				cartDAO.update(cart);
			}else{
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
