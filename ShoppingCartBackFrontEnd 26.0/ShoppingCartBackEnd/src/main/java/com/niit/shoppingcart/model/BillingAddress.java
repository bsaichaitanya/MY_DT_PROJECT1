package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
public class BillingAddress implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BillingAddress() {
		this.billingAddressId = "BILL" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
	
	@Id
	private String billingAddressId;
	private String user_id;
	private String b_line1;
	private String b_line2;
	private String b_city;
	private String b_state;
	private String b_country;
	private String b_zipCode;

	public String getBillingAddressId() {
		return billingAddressId;
	}
	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getB_line1() {
		return b_line1;
	}
	public void setB_line1(String b_line1) {
		this.b_line1 = b_line1;
	}
	public String getB_line2() {
		return b_line2;
	}
	public void setB_line2(String b_line2) {
		this.b_line2 = b_line2;
	}
	public String getB_city() {
		return b_city;
	}
	public void setB_city(String b_city) {
		this.b_city = b_city;
	}
	public String getB_state() {
		return b_state;
	}
	public void setB_state(String b_state) {
		this.b_state = b_state;
	}
	public String getB_country() {
		return b_country;
	}
	public void setB_country(String b_country) {
		this.b_country = b_country;
	}
	public String getB_zipCode() {
		return b_zipCode;
	}
	public void setB_zipCode(String b_zipCode) {
		this.b_zipCode = b_zipCode;
	}
	

}
