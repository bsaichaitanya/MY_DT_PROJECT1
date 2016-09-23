package com.niit.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class HomeController {

	
	/*
	@RequestMapping("/")
	public String homePage(){
			return "Home"
	}
	*/
	
	@Autowired //to inject the object in the home controller automatically
	CategoryDAO categoryDAO;
	
	
	
	@RequestMapping("/")
	public ModelAndView home(){
		ModelAndView m=new ModelAndView("/Home");
		m.addObject("message","Hi");
		//get all categories along with products
		//you have to integrate with the backend project
		List<Category> categoryList=categoryDAO.list();
		m.addObject("categoryList",categoryList);
		
		
		System.out.println("size:" +categoryList.size());
		return m;
	}
	
	@RequestMapping("/Register")
	public ModelAndView register(){
		ModelAndView mv=new ModelAndView("Registration");
		mv.addObject("userClickedRegisterHere",true);
		mv.addObject("message","You are in login page");
		return mv;
	}
	
	@RequestMapping("/Login")
	public ModelAndView Login(){
		ModelAndView m=new ModelAndView("Login");
		m.addObject("userClickedRegisterHere",true);
		return m;
	}
	
	
	
}
