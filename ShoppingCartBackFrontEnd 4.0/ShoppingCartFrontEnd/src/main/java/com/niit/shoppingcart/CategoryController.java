package com.niit.shoppingcart;




import javax.servlet.http.HttpSession;

import org.h2.engine.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {

	@Autowired
	private Category category;

	@Autowired
	private CategoryDAO categoryDAO;
	
	

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String listCategory(Model model) {
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		return "category";
	}

	@RequestMapping(value = "category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category) {
		//check if the record exist with this id
		//if exist, display error message to the admin record already  exist
		//else save the record
		
		ModelAndView mv = new ModelAndView("/category");
		if (categoryDAO.get(category.getId()) == null) {
			categoryDAO.save(category);
		} else {
		 
				categoryDAO.update(category);
		}
		return "redirect:/manageCategories";

	}
	
	
	@RequestMapping(value= "category/update/{id}")
	public String updateCategory(@PathVariable("id") String id ) {
		//check whether category exist with this id?
		//if exists, update the existing category
		//if doesnot exist display error message
		System.out.println("i am in updateCategory");
		//String id=category.getId();
		 category=categoryDAO.get(id);
			System.out.println(category.getId());
		ModelAndView mv = new ModelAndView();

		if (categoryDAO.get(category.getId()) != null) {
			categoryDAO.update(category);
			System.out.println("updated");
		} else {
			mv.addObject("ErrorMessage", "couldnot update the record");
		}
		return "redirect:/category";
	}

	@RequestMapping("category/remove/{id}")
	public String  deleteCategory(@PathVariable("id") String id)
			throws Exception {
		//if id exist in category delete it
		//else display error message
		System.out.println("i am in deleteCategory");
		System.out.println(id);
		Category category=categoryDAO.get(id);
		ModelAndView mv = new ModelAndView("category");
	
	boolean flag=	categoryDAO.delete(category);
		if(flag==true){
			System.out.println("i am in delete operation");
		}
		else{
			mv.addObject("ErrorMessage", "could not delete the record");
		}
		return "redirect:/manageCategories";
	}
}