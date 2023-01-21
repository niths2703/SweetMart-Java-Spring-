package com.sweetmart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sweetmart.dto.OrderBillDTO;
import com.sweetmart.exception.OrderBillException;
import com.sweetmart.model.OrderBill;
import com.sweetmart.model.SweetOrder;
import com.sweetmart.model.User;
import com.sweetmart.repo.OrderBillDao;
import com.sweetmart.repo.SweetOrderDao;

public class OrderBillServiceImp implements OrderBillService{
             
	   
	
	     @Autowired
	     public OrderBillDao orderBillDao;
	     
	     @Autowired SweetOrderDao sweetOrderDao;

		@Override
		public OrderBill createOrderBillService(User user, OrderBillDTO orderBillDTO) throws OrderBillException {
			// TODO Auto-generated method stub
			
			
			OrderBill orderBill = new OrderBill();
			
			orderBill.setSweetOrders(null);
			
			// calculate the price from SweetOrder;
			 Optional<SweetOrder> opt =   sweetOrderDao.findById(orderBillDTO.getSweetOrderId());
              if(opt.isPresent()) {
            	      SweetOrder sweetOrder =   opt.get();
            	      
            	      // Is this order 
            	      
            	      
            	      
              }else {
            	   throw new OrderBillException("There is no Sweet Order wt this id ");
              }
			
			
			
			
			return null;
		}

		@Override
		public OrderBill updateOrderBill(User user, OrderBillDTO orderBillDTO) throws OrderBillException {
			// TODO Auto-generated method stub
			return null;
		}

	
	 
	
}
