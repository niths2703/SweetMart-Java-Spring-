package com.sweetmart.service;
import com.sweetmart.dto.SweetOrderDTO;
import com.sweetmart.exception.SweetOrderException;
import com.sweetmart.model.SweetOrder;
import com.sweetmart.model.User;

public interface SweetOrderService {
	
	 
	public SweetOrder createSweetOrderService(User user, SweetOrderDTO sweetOrderDTO)  throws SweetOrderException;
	
	public SweetOrder updateNewSweetItemInSweetOrderService(User user, SweetOrderDTO sweetOrderDTO) throws SweetOrderException;

	public SweetOrder updateQuantityOfSweetItemsInSweetOrderService(User user, SweetOrderDTO sweetOrderDTO) throws SweetOrderException;
	
	
	public SweetOrder deleteSweetOrderService(User user, SweetOrderDTO sweetORderDTO) throws SweetOrderException;
	


}
