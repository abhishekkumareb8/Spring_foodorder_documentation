package com.ty.foodboot.springboot_foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodboot.springboot_foodapp.dao.ProductDao;
import com.ty.foodboot.springboot_foodapp.dto.Product;

import com.ty.foodboot.springboot_foodapp.exception.NoSuchElementFoundException;
import com.ty.foodboot.springboot_foodapp.exception.UnableToUpdateException;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao ;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> entity = new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveProduct(product));
		return entity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> entity = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteProductById(id));
		return entity;
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, int id) {
		Product  product2 = dao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> entity = new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		if (product2 != null) {
			product.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.updateProduct(product));

		} 
		else {
			throw new UnableToUpdateException("No Id Found To Update");
		}
		return entity;
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> entity = new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		Product  product2 = dao.getProductById(id);
		if (product2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Received");
			responseStructure.setData(dao.getProductById(id));
		} else {
			throw new NoSuchElementFoundException("No Id Found In Data Base For User");
		}
		return entity;
	}
}

