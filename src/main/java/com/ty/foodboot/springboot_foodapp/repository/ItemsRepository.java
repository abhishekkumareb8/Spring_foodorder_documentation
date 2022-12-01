package com.ty.foodboot.springboot_foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodboot.springboot_foodapp.dto.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer>{

}
