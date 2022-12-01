package com.ty.foodboot.springboot_foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodboot.springboot_foodapp.dto.FoodOrder;

public interface FoodOredrRepository extends JpaRepository<FoodOrder, Integer>{

}
