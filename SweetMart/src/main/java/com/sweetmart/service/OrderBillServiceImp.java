package com.sweetmart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetmart.dto.OrderBillDTO;
import com.sweetmart.exception.OrderBillException;
import com.sweetmart.model.Customer;
import com.sweetmart.model.OrderBill;
import com.sweetmart.model.SweetItem;
import com.sweetmart.model.SweetOrder;
import com.sweetmart.model.User;
import com.sweetmart.repo.CustomerDao;
import com.sweetmart.repo.OrderBillDao;
import com.sweetmart.repo.SweetOrderDao;


@Service
public class OrderBillServiceImp implements OrderBillService{
             
	   
	
	     @Autowired
	     private OrderBillDao orderBillDao;
	     
	     @Autowired 
	     private SweetOrderDao sweetOrderDao;
	     
	     
	     @Autowired 
	     private CustomerDao customerDao;

		@Override
		public OrderBill createOrderBillService(User user, OrderBillDTO orderBillDTO) throws OrderBillException {
			// TODO Auto-generated method stub
			
			
			
			
			// calculate the price from SweetOrder;
			 Optional<SweetOrder> opt =   sweetOrderDao.findById(orderBillDTO.getSweetOrderId());
              if(opt.isPresent()) {
            	      SweetOrder sweetOrder =   opt.get();
            	      
            	      
            	      
            	      // Is this order is for this customer and not placed yet
            	      if(sweetOrder.getCustomer().getUser().getUserID() == user.getUserID() && !sweetOrder.getIsOrderPalced()) {
            	    	  OrderBill orderBill = new OrderBill();
 
            				orderBill.setSweetOrders(sweetOrder);
            				int price = 0;
            				  Set<SweetItem> sweetItems = sweetOrder.getSweetItems();
            				  for(SweetItem s : sweetItems) {
            					    price +=   s.getProduct().getPrice() * s.getQuantity();
            				  }
            				orderBill.setTotalPrice(price);
            	    	  
            			  return 	orderBillDao.save(orderBill);
            				
            				
            				
            	      }else{
            	    	    throw new OrderBillException("Wrong order id or This order already checkout by you !");
            	      }
            	      
            	      
            	      
              }else {
            	   throw new OrderBillException("There is no Sweet Order wt this id ");
              }
			
			
			
			
			
		}

		@Override
		public OrderBill updateOrderBill(User user, OrderBillDTO orderBillDTO) throws OrderBillException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<OrderBill> getAllOrderBillService(User user) throws OrderBillException {
			// TODO Auto-generated method stub
			           
			       Optional<Customer> opt =  customerDao.findByUserId( user.getUserID());
			       
			       if(opt.isPresent()) {
			    	        List<SweetOrder> sweetOrders =    opt.get().getSweetOrders();
			    	        List<OrderBill> orderBills = new ArrayList<>();
			    	        
			    	        for(SweetOrder sweetOrder : sweetOrders) {
			    	        	  if(sweetOrder.getIsOrderPalced() == true) {
			    	        		Optional<OrderBill> opt1 =  orderBillDao.findBySweetOrderId(sweetOrder.getSweetOrderID());          
			    	        	          
			    	        		if(opt1.isPresent()) {
			    	        			   orderBills.add(opt1.get());
			    	        		}
			    	        	         
			    	        	  
			    	        	  }
			    	        }
			    	        
			    	        if(orderBills.size() == 0) {
			    	        	   throw new OrderBillException("There is no pervious order history");
			    	        }
			    	        
			    	        
			    	        return orderBills;
			    	           
			       }else {
			    	      throw new  OrderBillException("There is no pervious order yet");
			       }
			       
			
			  
		}

		
	
		@Override
		public OrderBill getOrderBillByIdService(User user, Integer id) throws OrderBillException {
			// TODO Auto-generated method stub
		         Optional<OrderBill>   opt =orderBillDao.findById(id);    
		              if(opt.isPresent()) {
		            	      OrderBill orderBill =  opt.get();
		            	      if(orderBill.getSweetOrders().getCustomer().getUser().getUserID() == user.getUserID()) {
		            	    	      return orderBill;
		            	      }else {
		            	    	   throw new OrderBillException("There is no order bill with this id: "+id);
		            	      }
		              }else {
		            	  throw new OrderBillException("There is no order with this id: "+id);
		              }
			    
		}

	
	 
	
}
