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
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

public class TestCaseProduct {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Product product;
	
	@Autowired
Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;
	
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
	/*Category category=new Category();
		category.setCat_id("CAT002");
		category.setCat_name("mobile");
		category.setCat_description("MOBILES");
		
		
		Supplier supplier=new Supplier();
		supplier.setSup_id("SUP002");
		supplier.setSup_name("RELAINCE");
		supplier.setSup_address("hyd");
	
		Product product=new Product();*/
		
		
		product.setPro_id("PRO4");
		product.setPro_name("lenovo");
		product.setPro_description("lenevo mob");
		product.setPro_price("1500"); 
		product.setCategory_id("cat1");
		product.setSupplier_id("s1");
		 //productDAO.save(product);
		 assertEquals(productDAO.save(product),true);
		/*(category.getProducts()).add(product);
		
		
		(supplier.getProducts()).add(product);
	
		
		 categoryDAO.save(category);
		supplierDAO.save(supplier);*/
	
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
