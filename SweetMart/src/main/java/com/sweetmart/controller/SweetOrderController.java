package com.sweetmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweetmart.dto.SweetOrderDTO;
import com.sweetmart.model.SweetOrder;
import com.sweetmart.model.User;
import com.sweetmart.service.LoginService;
import com.sweetmart.service.SweetOrderService;

@RestController
public class SweetOrderController {


           // 3 type of request handler   1. add sweet order
                 //    2. update order
            //       3. delete order
	
	     @Autowired
	     private LoginService loginService;
	     
	     @Autowired
	     private SweetOrderService sweetOrderService;
	
	    
	     @PostMapping("/customer")           
	   public ResponseEntity<SweetOrder> addSweetOrderHandler(@RequestBody SweetOrderDTO sweetOrderDTO){
	    	 
	    	 // check for credentials 
	    	    User   user =    loginService.checkForCrendentialsService(sweetOrderDTO.getKey());
	    	    
	    	  // call SweetOrder Service 
	    	   SweetOrder  sweetOrder =  sweetOrderService.createSweetOrderService(user, sweetOrderDTO);
	    	 return  new ResponseEntity<SweetOrder>(sweetOrder, HttpStatus.OK);
	   }
	     
	     
	   // update a order    ---> 1. add extra product with its quantity
//	                        ---> 2. increase the existing product quantity
//	                        ---->3. Reduce a exiting sweetItem quantity 
	     
	       // 1 . add extra sweetItem with its quantity
	     @PutMapping("/customer/sweetItem")
	     public ResponseEntity<SweetOrder> updateNewSweetItemInSweetOrderHandler(@RequestBody SweetOrderDTO sweetOrderDTO){
	    	 // check for credentials 
	    	    User   user =    loginService.checkForCrendentialsService(sweetOrderDTO.getKey());
	    	    
	    	    //  1. SweetOrder Id, 2. New Product Id, 3. quantity 
	    	        
	    	 
	    	     SweetOrder sweetOrder = sweetOrderService.updateNewSweetItemInSweetOrderService(user, sweetOrderDTO);
	    	    return new ResponseEntity<SweetOrder>(sweetOrder, HttpStatus.OK);
	     }
	     
	     
	     
//	     @PutMapping("/customer/quantity")
//	     public ResponseEntity<>
	     
	     
	     
	     


    // 1. request  --> key ,List( product id, quenatity of that product)    --> SweetOrderDTO  --> (1. key , List of products + quantity)

   //  call to SweetOrderService(User usSweetOrderDTO
    // return SweetOrder

}
