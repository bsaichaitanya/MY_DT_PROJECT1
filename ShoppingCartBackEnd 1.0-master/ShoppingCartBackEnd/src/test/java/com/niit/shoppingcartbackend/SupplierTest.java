package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	 SupplierDAO supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
	 Supplier supplier=(Supplier) context.getBean("supplier");
	supplier.setId("cs101");
	supplier.setName("Roopesh");
	supplier.setAddress(" i dont know ");
	
	if(supplierDAO.save(supplier)==true){
		System.out.println("supplier saved successfully");
	}
	else{
		System.out.println(" saving is unsuccessful");
	}
	
}
}
