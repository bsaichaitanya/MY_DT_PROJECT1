package com.niit.shoppingcart.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Category {

	@Id
	private String cat_id;
	@NotEmpty
	private String cat_name;
	@NotEmpty
	private String cat_description;
	
	
	

	@OneToMany(fetch=FetchType.EAGER,mappedBy="category")
	private Set<Product> products;
	public Set<Product> getProducts() {
		return products;
	}

	public void SetProducts(Set<Product> products) {
		this.products = products;
	}

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getCat_description() {
		return cat_description;
	}

	public void setCat_description(String cat_description) {
		this.cat_description = cat_description;
	}

	

}




