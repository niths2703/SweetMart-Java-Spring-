package com.sweetmart.service;

import com.sweetmart.dto.OrderBillDTO;
import com.sweetmart.exception.OrderBillException;
import com.sweetmart.model.OrderBill;
import com.sweetmart.model.User;

public interface OrderBillService {
             
	    
	public OrderBill createOrderBillService(User user, OrderBillDTO orderBillDTO) throws OrderBillException;
	
	
	public OrderBill  updateOrderBill(User user, OrderBillDTO orderBillDTO) throws OrderBillException;
	

}
