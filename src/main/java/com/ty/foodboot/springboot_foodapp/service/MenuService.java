package com.ty.foodboot.springboot_foodapp.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodboot.springboot_foodapp.dao.MenuDao;
import com.ty.foodboot.springboot_foodapp.dto.Menu;
import com.ty.foodboot.springboot_foodapp.exception.UnableToUpdateException;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@Service
public class MenuService {

	@Autowired
	private MenuDao dao;
	
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		ResponseEntity<ResponseStructure<Menu>> responseEntity= new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveMenu(menu));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteMenu(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity= new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteMenuById(id));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu, int id) {
		Menu menu2 = dao.getMenuById(id);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		ResponseEntity<ResponseStructure<Menu>> responseEntity= new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
		if(menu2!=null) {
			menu.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.updateMenu(menu));
		
		}else
		{
//			responseStructure.setStatus(HttpStatus.OK.value());
//			responseStructure.setMessage("Not found");
//			responseStructure.setData(null);
			throw new UnableToUpdateException("No Id Found To Update");
		}
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id){
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		ResponseEntity<ResponseStructure<Menu>> responseEntity= new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
		Menu menu2= dao.getMenuById(id);
		if(menu2!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(dao.getMenuById(id));
		return responseEntity;
		}
		else {
			throw new NoSuchElementException("No Id Found");
		}
	}
}
