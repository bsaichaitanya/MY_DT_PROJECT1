package com.niit.shoppingcart.model;


import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart implements Serializable{
	public Cart(){
		this.cart_id="CART"+UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
    private static final long serialVersionUID = 1L;
	
 
	@Id
	private String cart_id;
	private String productID;
	private String userID;
	private String productName;
	private String productPrice;
	private int quantity;
	
	@OneToOne
	@JoinColumn(name="userID",  insertable=false, nullable=false, updatable= false)
	private UserDetails userDetails;
	
	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}


	@Transient
	private String total;

	public String getCart_id() {
		return cart_id;
		}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	
	
}
