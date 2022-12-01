package com.ty.foodboot.springboot_foodapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodboot.springboot_foodapp.dto.User;
import com.ty.foodboot.springboot_foodapp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repository ;
	
	public User saveUser(User user ) {
		return repository.save(user);
	}
	
	public User updateUser(User user ) {
		return repository.save(user);
	}
	
	public User getUserById(int id) {
		Optional<User> optional =repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String deleteUserById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
}
