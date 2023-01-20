package com.sweetmart.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sweetmart.exception.OrderBillException;
import com.sweetmart.model.OrderBill;
import com.sweetmart.model.User;
import com.sweetmart.repo.OrderBillDao;

public class OrderBillServiceImp implements OrderBillService{
             
	   
	
	     @Autowired
	     public OrderBillDao orderBillDao;

		@Override
		public OrderBill createOrderBillService(User user, OrderBill orderBill) throws OrderBillException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public OrderBill updateOrderBill(User user, OrderBill orderBill) throws OrderBillException {
			// TODO Auto-generated method stub
			return null;
		}
	     
	 
	
}
