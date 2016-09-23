package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	 CategoryDAO categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	 Category category=(Category) context.getBean("category");
	category.setId("cs101");
	category.setName("Roopesh");
	category.setDescription(" i dont know ");
	
	if(categoryDAO.save(category)==true){
		System.out.println("category saved successfully");
	}
	else{
		System.out.println(" saving is unsuccessful");
	}
	
}
}
