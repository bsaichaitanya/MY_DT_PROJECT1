package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

public class TestCaseProduct {

	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Product product;
	
	@Autowired
	Category category ; 
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		product = (Product)context.getBean("product");
	}
	
	
	@Test
	public void productAddTestCase()
	{
	Category category=new Category();
		category.setCat_id("cat001");
		category.setCat_name("mobile");
		category.setCat_description("ddsasd");
	
		Product product=new Product();
		Product product2=new Product();
		product.setPro_id("pro001");
		product.setPro_name("birthday gifts");
		product.setPro_description("dssdasdsdsd");
		product.setPro_price("5000"); 
		product.setCategory(category);
		 productDAO.save(product);
		 
		 
		product2.setPro_id("pro002");
		product2.setPro_name("birthday cards");
		product2.setPro_description("ggggggggg");
		product2.setPro_price("4000"); 
		product2.setCategory(category);
		productDAO.save(product2);
		(category.getProducts()).add(product);
		(category.getProducts()).add(product2);
		
		assertEquals( categoryDAO.save(category),true);
	}

	/*
	
	@Test
	public void productListTestCase()
	{
		List<Product> list = productDAO.list();
		int rowCount = list.size();
		assertEquals("Product List Test Case", rowCount,2);
	}
	
	@Test
	public void deleteTestCase(){
		product.setId("PRO_001");
		assertEquals(productDAO.delete(product),true);
	}
	
	@Test
	public void updateTestCase(){
		product.setId("PRO_002");
		product.setName("asus");
		product.setDescription("this is asus");
		product.setPrice("15000");
		assertEquals(productDAO.update(product),true);
	}
*/
	/*@Test
	public void getProductTestCase(){
		product=productDAO.get("PRO_003");
		System.out.println(product.getDescription());
		assertEquals(product.getName(),"dell");
	}
	*/
	
	
	
	
	

}
