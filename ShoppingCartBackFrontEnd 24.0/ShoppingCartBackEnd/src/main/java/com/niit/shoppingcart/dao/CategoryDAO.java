package com.niit.shoppingcart.dao;

import java.util.List;



import com.niit.shoppingcart.model.Category;

public interface CategoryDAO {
	public boolean save(Category category);

	public boolean update(Category category);

	public boolean delete(Category category);

	public Category get(String cat_id);

	public List<Category> list();
	
	public Category getByName(String name);
}
