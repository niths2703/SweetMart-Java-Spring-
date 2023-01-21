package com.sweetmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweetmart.dto.OrderBillDTO;
import com.sweetmart.model.OrderBill;
import com.sweetmart.model.User;
import com.sweetmart.service.LoginService;
import com.sweetmart.service.OrderBillService;




@RestController
public class OrderBillController {
            
	
	@Autowired
     public OrderBillService orderBillservice;
	
	@Autowired 
	public LoginService loginService;
	
	
	@PostMapping("/customer/orders")
	public ResponseEntity<OrderBill> addOrderBillHandler(@RequestBody OrderBillDTO orderBillDTO){
		      
		
		   // check for credentials    
		 User user =  loginService.checkForCrendentialsService(orderBillDTO.getKey());
		
		OrderBill orderBill = orderBillservice.createOrderBillService(user, orderBillDTO);            
		     
		
		return new ResponseEntity<>(orderBill, HttpStatus.OK);
		        
		
	}
	
	
	// get all order Bill
	@PostMapping("/customer/orders")
	public  ResponseEntity<List<OrderBill>> getAllOrderBillHandler(@RequestBody String key){
		   // check for credentials    
				 User user =  loginService.checkForCrendentialsService(key); 
				 
				 
				List<OrderBill> orderBills = orderBillservice.getAllOrderBillService(user);
				 
				 
				 
				 return new ResponseEntity<List<OrderBill>>(orderBills, HttpStatus.OK);
		
	}
	
	
	
	// get a order Bill by id
	@PostMapping("/customer/orders/{id}")
	public ResponseEntity<OrderBill>    getOrderBillByIdHandler(@PathVariable("id") Integer id,  @RequestBody String key){
		   
		
		// check for credentials
		    User user =   loginService.checkForCrendentialsService(key);
		    
		    
		   OrderBill   orderBill =     orderBillservice.getOrderBillByIdService(user, id);
		    
		    
		
		return new ResponseEntity<OrderBill>(orderBill, HttpStatus.OK);
	}
	
}
