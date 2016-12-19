package com.niit.shoppingcart.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class UserDetails  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Length(min = 6, max = 15, message = "Id should contain 6-15 characters")
	private String id;
	
	@NotBlank(message = "Name field can not be blank")
	@Length(min = 5 , message = "Name contains atleast 5 character")
	private String username;
	
	@Email(message="Please provide a valid email address")
	private String mail;

	@NotBlank
	private String address;
	
	@Pattern(regexp="(^$|[0-9]{10})", message = "Please provide a valid phone no.")
	private String contact;
	
	@NotBlank(message="Please select a password")
	@Length(min=4, max=15, message="Password should be between 4 - 15 charactes")
	private String password;
	
	private String role="ROLE_USER";



	public String getRole() {
		return role;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
