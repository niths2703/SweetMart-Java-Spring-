package com.sweetmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sweetmart.dto.OrderBillDTO;
import com.sweetmart.model.OrderBill;
import com.sweetmart.model.User;
import com.sweetmart.service.LoginService;
import com.sweetmart.service.OrderBillService;

public class OrderBillController {
            
	
	@Autowired
     public OrderBillService orderBillservice;
	
	@Autowired 
	public LoginService loginService;
	
	
	@PostMapping("/customers")
	public ResponseEntity<OrderBill> addOrderBillHandler(@RequestBody OrderBillDTO orderBillDTO){
		      
		
		   // check for credentials    
		 User user =     loginService.checkForCrendentialsService(orderBillDTO.getKey());
		
		 //  orderBillservice.createOrderBillService(user, orderBillDTO);            
		     
		
		return null;
		        
		
	}
	
	
	
}
