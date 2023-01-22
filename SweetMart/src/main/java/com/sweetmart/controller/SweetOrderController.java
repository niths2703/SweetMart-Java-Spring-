package com.sweetmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweetmart.dto.SweetOrderDTO;
import com.sweetmart.exception.SweetOrderException;
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
       //	                ---> 2. changing the existing sweetItem quantity
	                       
	     
	       // 1 . add extra sweetItem with its quantity
	     @PutMapping("/customer/sweetItem")
	     public ResponseEntity<SweetOrder> updateNewSweetItemInSweetOrderHandler(@RequestBody SweetOrderDTO sweetOrderDTO){
	    	 // check for credentials 
	    	    User   user =    loginService.checkForCrendentialsService(sweetOrderDTO.getKey()); 
	    	        
	    	 
	    	     SweetOrder sweetOrder = sweetOrderService.updateNewSweetItemInSweetOrderService(user, sweetOrderDTO);
	    	    return new ResponseEntity<SweetOrder>(sweetOrder, HttpStatus.OK);
	     }
	     
	     
	     // 2. change the existing sweetItem quantity.
	     @PutMapping("/customer/quantity")
	     public ResponseEntity<SweetOrder>   changeQuantityOfSweetItemInSweetOrderHandler(@RequestBody SweetOrderDTO sweetOrderDTO){
	    	  
	    	 // check for credentials 
	    	    User   user =    loginService.checkForCrendentialsService(sweetOrderDTO.getKey());
	    	    
	    	    
	    	 
	    	 
	    	 
	    	     SweetOrder sweetOrder =  sweetOrderService.updateQuantityOfSweetItemsInSweetOrderService(user, sweetOrderDTO);
	    	 return new ResponseEntity<SweetOrder>(sweetOrder, HttpStatus.OK);
	     }
	     
	     
	     
	     // Delete a order
	     @DeleteMapping("customer/order/delete")
	     public ResponseEntity<SweetOrder>  deleteSweetOrderHandler(@RequestBody SweetOrderDTO sweetOrderDTO){
	    	 
	    	 // check for credentials 
	    	    User   user =    loginService.checkForCrendentialsService(sweetOrderDTO.getKey());
	    	    
	    	    
	    	   SweetOrder sweetOrder = sweetOrderService.deleteSweetOrderService(user, sweetOrderDTO);
	    	    
	    	 
	    	 return new ResponseEntity<SweetOrder>(sweetOrder, HttpStatus.ACCEPTED);
	     }

}
