package com.ty.foodboot.springboot_foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodboot.springboot_foodapp.dto.Product;
import com.ty.foodboot.springboot_foodapp.repository.ProductRepository;

@Repository
public class ProductDao {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product ) {
		return repository.save(product);
	}
	
	public Product updateProduct(Product product ) {
		return repository.save(product);
	}
	
	public Product getProductById(int id) {
		Optional<Product> optional = repository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	public String deleteProductById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
}
