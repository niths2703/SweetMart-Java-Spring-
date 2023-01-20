package com.sweetmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sweetmart.model.OrderBill;
import com.sweetmart.service.OrderBillService;

public class OrderBillController {
            
	
	@Autowired
     public OrderBillService orderBillservice;
	
	
	@PostMapping("/customers")
	public ResponseEntity<OrderBill> addOrderBillHandler(@RequestBody OrderBill orderBill){
		   
		     
		
		return null;
		        
		
	}
	
	
	
}
