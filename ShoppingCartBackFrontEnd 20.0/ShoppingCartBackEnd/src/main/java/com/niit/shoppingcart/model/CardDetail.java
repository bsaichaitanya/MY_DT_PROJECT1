package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
public class CardDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public CardDetail() {

		this.cardDetailId = "CARD" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
	@Id
	private String cardDetailId;
	private String user_id;
	private String cardNumber;
	private String expiryMonth;
	private String expiryYear;
	private String cvvNumber;
	private String nameOnCard;
	private double totalCost;

	public String getCardDetailId() {
		return cardDetailId;
	}

	public void setCardDetailId(String cardDetailId) {
		this.cardDetailId = cardDetailId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


}
