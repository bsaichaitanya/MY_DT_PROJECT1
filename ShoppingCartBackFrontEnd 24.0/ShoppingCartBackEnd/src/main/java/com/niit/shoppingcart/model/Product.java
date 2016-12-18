package com.niit.shoppingcart.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product {

	@Id
	private String pro_id;
	private String pro_name;
	private String pro_description;
	private int pro_price;
	private int pro_quantity;


	public int getPro_quantity() {
		return pro_quantity;
	}
	public void setPro_quantity(int pro_quantity) {
		this.pro_quantity = pro_quantity;
	}

	private String category_id;
		private String supplier_id;
		@Transient
		private MultipartFile image;
		
		public MultipartFile getImage() {
			return image;
		}
		public void setImage(MultipartFile image) {
			this.image = image;
		}
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
	
	@ManyToOne
	@JoinColumn(name="category_id" ,updatable=false,insertable=false,nullable=false)
	private Category category;
	
	
	@ManyToOne
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
	
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

}
