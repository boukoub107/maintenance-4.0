package net.mant.maintenanceBackend.dao;

import java.util.List;

import net.mant.maintenanceBackend.dto.Category;

public interface CategoryDAO {

	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
}
