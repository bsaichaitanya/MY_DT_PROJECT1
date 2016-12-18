package com.niit.shoppingcart.model;

import java.io.Serializable;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
public class ShippingAddress implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ShippingAddress() {
		this.shippingAddressId = "SHIP" + UUID.randomUUID().toString().substring(24).toUpperCase();
	} 
	
	@Id
	private String shippingAddressId;
	private String user_id;
	private String s_line1;	
	private String s_line2;
	private String s_city;
	private String s_state;
	private String s_country;
	private String s_zipCode;

	public String getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(String shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getS_line1() {
		return s_line1;
	}
	public void setS_line1(String s_line1) {
		this.s_line1 = s_line1;
	}
	public String getS_line2() {
		return s_line2;
	}
	public void setS_line2(String s_line2) {
		this.s_line2 = s_line2;
	}
	public String getS_city() {
		return s_city;
	}
	public void setS_city(String s_city) {
		this.s_city = s_city;
	}
	public String getS_state() {
		return s_state;
	}
	public void setS_state(String s_state) {
		this.s_state = s_state;
	}
	public String getS_country() {
		return s_country;
	}
	public void setS_country(String s_country) {
		this.s_country = s_country;
	}
	public String getS_zipCode() {
		return s_zipCode;
	}
	public void setS_zipCode(String s_zipCode) {
		this.s_zipCode = s_zipCode;
	}


	

}
