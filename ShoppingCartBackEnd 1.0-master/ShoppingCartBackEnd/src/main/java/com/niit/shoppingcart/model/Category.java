package com.niit.shoppingcart.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity  //Entity,Table,Id are annotations and are interfaces
@Table // @Table(name="table_name") use this annotation if table_name and domain class_name are different,
@Component
public class Category {
	
	
	//id,name,description are fields in the table
	//@column(name="table-field_name") use this annotations if table fields and class variables name are different 
	//@ID converts variable into primary key
	//@transient if the variable is not required to store in data base use that annotation before that variable
	
	
	@Id 
	private String id;
	
	
	private String name;
	
	@NotEmpty
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
