package com.ty.foodboot.springboot_foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodboot.springboot_foodapp.dto.Menu;
import com.ty.foodboot.springboot_foodapp.repository.MenuRepository;

@Repository
public class MenuDao {
	
	@Autowired
	private MenuRepository repository;

	public Menu saveMenu(Menu menu) {
		return repository.save(menu);
	}
	
	public Menu updateMenu(Menu menu ) {
		return repository.save(menu);
	}
	
	public Menu getMenuById(int id) {
		Optional<Menu> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String deleteMenuById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
}
