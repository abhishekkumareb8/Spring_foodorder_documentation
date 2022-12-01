package com.ty.foodboot.springboot_foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodboot.springboot_foodapp.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
