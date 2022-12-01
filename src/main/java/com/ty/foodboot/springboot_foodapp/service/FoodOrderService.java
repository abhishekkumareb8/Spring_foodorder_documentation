package com.ty.foodboot.springboot_foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodboot.springboot_foodapp.dao.FoodOrderDao;
import com.ty.foodboot.springboot_foodapp.dto.FoodOrder;
import com.ty.foodboot.springboot_foodapp.dto.Product;
import com.ty.foodboot.springboot_foodapp.dto.User;
import com.ty.foodboot.springboot_foodapp.exception.NoSuchElementFoundException;
import com.ty.foodboot.springboot_foodapp.exception.UnableToUpdateException;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@Service
public class FoodOrderService {
	
	@Autowired
	private FoodOrderDao dao ;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder ) {
		List<Product> list=foodOrder.getList();
		double totelCost=0;
		for(Product product:list) {
			totelCost=totelCost+(product.getPrice()*product.getQuantity());
		}
		totelCost=(totelCost*0.18)+totelCost;
		foodOrder.setTotelCost(totelCost);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		ResponseEntity<ResponseStructure<FoodOrder>> responseEntity= new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteFoodOrder(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity= new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteFoodOrderById(id));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodOrder, int id) {
		FoodOrder foodOrder2= dao.getFoodOrderById(id);
		List<Product> list=foodOrder.getList();
		double totelCost=0;
		for(Product product:list) {
			totelCost=totelCost+(product.getPrice()*product.getQuantity());
		}
		totelCost=(totelCost*0.18)+totelCost;
		foodOrder.setTotelCost(totelCost);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		ResponseEntity<ResponseStructure<FoodOrder>> responseEntity= new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		if (foodOrder2 != null) {
			foodOrder.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.updateFoodOrder(foodOrder));

		} 
		else {
			throw new UnableToUpdateException("No Id Found To Update");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		ResponseEntity<ResponseStructure<FoodOrder>> responseEntity= new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		FoodOrder foodOrder2 = dao.getFoodOrderById(id);
		if (foodOrder2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Received");
			responseStructure.setData(dao.getFoodOrderById(id));
		} else {
			throw new NoSuchElementFoundException("No Id Found In Data Base For User");
		}
		return responseEntity;
	}

}
