package com.niit.shoppingcart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Product {

	@Id
	private String pro_id;
	private String pro_name;
	private String pro_description;
	private String pro_price;
	private String category_id;
		private String supplier_id;
		
		public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
		

	public String getSupplier_id() {
			return supplier_id;
		}
		public void setSupplier_id(String supplier_id) {
			this.supplier_id = supplier_id;
		}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id" ,updatable=false,insertable=false,nullable=false)
	private Category category;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="supplier_id", updatable=false,insertable=false,nullable=false)
	private Supplier supplier;
	
		 public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getPro_price() {
		return pro_price;
	}
	public void setPro_price(String pro_price) {
		this.pro_price = pro_price;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_description() {
		return pro_description;
	}
	public void setPro_description(String pro_description) {
		this.pro_description = pro_description;
	}
	
	

}
