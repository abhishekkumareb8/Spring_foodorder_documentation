package com.ty.foodboot.springboot_foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodboot.springboot_foodapp.dao.UserDao;
import com.ty.foodboot.springboot_foodapp.dto.User;
import com.ty.foodboot.springboot_foodapp.exception.NoSuchElementFoundException;
import com.ty.foodboot.springboot_foodapp.exception.UnableToUpdateException;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> responseEntity =new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveUser(user));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity =new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteUserById(id));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<User>> updateUser1(User user, int id) {
		User user2 = dao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> responseEntity =new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		if (user2 != null) {
			user.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.updateUser(user));

		} 
		else {
			throw new UnableToUpdateException("No Id Found To Update");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> responseEntity =new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		User user2 = dao.getUserById(id);
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Received");
			responseStructure.setData(dao.getUserById(id));
		} else {
			throw new NoSuchElementFoundException("No Id Found In Data Base For User");
		}
		return responseEntity;
	}

}
