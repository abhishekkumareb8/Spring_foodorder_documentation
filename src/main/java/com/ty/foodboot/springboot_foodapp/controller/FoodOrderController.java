package com.ty.foodboot.springboot_foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodboot.springboot_foodapp.dto.FoodOrder;
import com.ty.foodboot.springboot_foodapp.service.FoodOrderService;
import com.ty.foodboot.springboot_foodapp.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("foodorder")
public class FoodOrderController {

	@Autowired
	private FoodOrderService service; 
	
	@ApiOperation(value = "Save FoodOrder", notes = "It is used to save FoodOrder")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<FoodOrder>> saveUser(@RequestBody FoodOrder foodOrder) {
		return service.saveFoodOrder(foodOrder);
	}
	
	@ApiOperation(value = "Get FoodOrder", notes = "It is used to Get FoodOrder")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<FoodOrder>> getUserById(@RequestParam int id){
		return service.getFoodOrderById(id);
	}
	@ApiOperation(value = "Update FoodOrder", notes = "It is used to Update FoodOrder")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<FoodOrder>> updateUserById(@RequestBody FoodOrder foodOrder , @RequestParam int id){
		return service.updateFoodOrder(foodOrder, id);
	}
	@ApiOperation(value = "Delete FoodOrder", notes = "It is used to Delete FoodOrder")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@RequestParam int id){
		return service.deleteFoodOrder(id);
	}
}
