package com.niit.shoppingcart;

import java.io.IOException;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class HomeController {

 Logger log=LoggerFactory.getLogger(HomeController.class);
	@Autowired
	// to inject the object in the home controller automatically
	CategoryDAO categoryDAO;
	
	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	UserDetails userDetails;
	
	@Autowired
	Product product;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	Category category;

	@RequestMapping("/")
	public ModelAndView home(Model model,HttpSession session) {
		ModelAndView m = new ModelAndView("Home");
		model.addAttribute("carousel", true);
		// get all categories along with products
		// you have to integrate with the backend project
	

		session.setAttribute("supplier",supplier);
		session.setAttribute("supplierList",supplierDAO.list());

		session.setAttribute("product",product);
		session.setAttribute("productList",productDAO.list());
		
		session.setAttribute("category",category);
		session.setAttribute("categoryList",categoryDAO.list());
		
		return m;
	}
	
	@RequestMapping("/Home")
	public String returnHome(Model model,HttpSession session){
		model.addAttribute("carousel", true);
		session.setAttribute("product",product);
		session.setAttribute("productList",productDAO.list());
		
		session.setAttribute("category",category);
		session.setAttribute("categoryList",categoryDAO.list());
		return "Home";
		
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userDetails") UserDetails userDetails,HttpSession session) {
		
		ModelAndView mv = new ModelAndView("/Home");


		if(userDetailsDAO.get(userDetails.getId())==null){
			userDetailsDAO.save(userDetails);
			mv.addObject("successRegister", "true");
			mv.addObject("SuccessMessage","YOU ARE SUCCESSFULLY REGISTER,PLEASE LOGIN WITH THIS CREDENTIALS");
		}
		else{
			mv.addObject("userExist", "true");
		mv.addObject("failureMessage","USER EXIST WITH THIS ID,PLEASE REGISTER WITH NEW USER ID");
		}
		return mv;
	}
	
	@RequestMapping("/Registration")
	public ModelAndView register(HttpSession session) {
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("RegisterMsg", "REGISTER");
		mv.addObject("userDetails", userDetails);
		mv.addObject("userClickedRegisterHere", true);

		session.setAttribute("product",product);
		session.setAttribute("productList",productDAO.list());
		
		session.setAttribute("category",category);
		session.setAttribute("categoryList",categoryDAO.list());
		return mv;
	}

/*	@RequestMapping(value="login" , method=RequestMethod.POST)
	public String Login() {
	log.debug("///////////////////I am inn Login method//////////");
	session.setAttribute("product",product);
		session.setAttribute("productList",productDAO.list());
		session.setAttribute("category",category);
		session.setAttribute("categoryList",categoryDAO.list());
		ModelAndView m = new ModelAndView("/Home");
		m.addObject("LoginMsg", "LOGIN");
		m.addObject("userDetails", userDetails);
		m.addObject("userClickedLoginHere", true);
		return "login";
	}*/
	
	@RequestMapping("/login")
		public String login(@RequestParam(value="error",required=false) String error,
				@RequestParam(value="logout",required=false) String logout, 
				Model model, HttpSession session){
			log.info("///////////////start of login method//////////////");
			model.addAttribute("userClickedLoginHere", true);
				if(error!=null)
			model.addAttribute("error","Invalid username and password");
			
			if(logout!=null)
				model.addAttribute("logout","You have logged out successfully");

			log.info("///////////////end of login method//////////////");
			return"Home";	
		
		}



	
	@RequestMapping(value="about")
	public String about(Model model){
		model.addAttribute("clickedAbout", true);		
		return "Home";
		
	}  
    
    @RequestMapping("/403")
	public String denied(Model model) {
	model.addAttribute("accessDenied", true);
		return "Home";
	}
	
}
