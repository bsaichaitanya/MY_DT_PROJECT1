package com.niit.shoppingcart;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.h2.engine.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class UserDetailsController {
	// when user clicked login based on the credentials i want to find whether
	// he is admin or not
	// if he is admin, he has to navigate to adminHomePage
	// if he is user, he has to navigate to home page
	// if user does not exist, display error message

	@Autowired
	UserDetailsDAO userDetailsDAO;

	@Autowired
	UserDetails userDetails;

	@Autowired
	Category category;

	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value = "id") String id,
			@RequestParam(value = "password") String password,
			HttpSession session) {
		ModelAndView mv = new ModelAndView("Home");
		String msg;
		userDetails = userDetailsDAO.isValidUser(id, password);
		if (userDetails == null) {
			msg = "Invalid user please try again with valid user  details";
		} else {
			// find out whether the user is admin or not
			if (userDetails.getRole().equals("ROLE_ADMIN")) {
				mv = new ModelAndView("adminHome");
			}
			session.setAttribute("welcomeMsg", userDetails.getName());
			session.setAttribute("userID", userDetails.getId());
		}

		return mv;

	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("/Home");
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO);

		mv.addObject("logoutMsg", "you are successfully loggedout");
		mv.addObject("loggedout", "true");
		return mv;

	}
}
