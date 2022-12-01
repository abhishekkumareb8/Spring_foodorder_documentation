package com.ty.foodboot.springboot_foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodboot.springboot_foodapp.dto.FoodOrder;
import com.ty.foodboot.springboot_foodapp.repository.FoodOredrRepository;

@Repository
public class FoodOrderDao {
	
	@Autowired
	private FoodOredrRepository repository;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder ) {
		return repository.save(foodOrder);
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodOrder ) {
		return repository.save(foodOrder);
	}
	
	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String deleteFoodOrderById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
}
