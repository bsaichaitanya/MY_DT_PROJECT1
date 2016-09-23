package com.niit.shoppingcart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	/*
	@RequestMapping("/")
	public String homePage(){
			return "Home"
	}
	*/
	
	@RequestMapping("/")
	public ModelAndView home(){
		ModelAndView m=new ModelAndView("/Home");
		m.addObject("message","hi");
		return m;
	}
	
	@RequestMapping("/Register")
	public ModelAndView register(){
		ModelAndView m=new ModelAndView("Registration");
		m.addObject("userClickedRegister",true);
		return m;
	}
	
	@RequestMapping("/Login")
	public ModelAndView Login(){
		ModelAndView m=new ModelAndView("Login");
		m.addObject("userClickedRegister",true);
		return m;
	}
	
	
	
}
