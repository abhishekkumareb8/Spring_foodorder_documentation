package com.ty.foodboot.springboot_foodapp.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodboot.springboot_foodapp.dao.ItemsDao;
import com.ty.foodboot.springboot_foodapp.dto.Items;
import com.ty.foodboot.springboot_foodapp.dto.User;
import com.ty.foodboot.springboot_foodapp.exception.UnableToUpdateException;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@Service
public class ItemsService {
	
	@Autowired
	private ItemsDao dao;

	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		ResponseEntity<ResponseStructure<Items>> responseEntity=new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveItems(items));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteItems(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteItemsById(id));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Items>> updateItems(Items items, int id) {
		Items items2 = dao.getItemsById(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		ResponseEntity<ResponseStructure<Items>> responseEntity=new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
		if(items2!=null) {
			items.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.updateItems(items));
		
		}else
		{
			throw new UnableToUpdateException();
		}
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Items>> getItemsById(int id){
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		ResponseEntity<ResponseStructure<Items>> responseEntity=new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
		Items items2=dao.getItemsById(id);
		if(items2!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(dao.getItemsById(id));
		return responseEntity;
		}
		else {
			throw new NoSuchElementException();
		}
	}
}
