package com.sweetmart.service;

import com.sweetmart.exception.LoginException;
import com.sweetmart.exception.SweetOrderException;
import com.sweetmart.model.SweetOrder;

import java.util.List;

public interface SweetOrderService {



    public SweetOrder deleteSweetorderbyId(Integer id ,String key) throws SweetOrderException, LoginException ;
    public List<SweetOrder> getallSweetorder( String key)  throws SweetOrderException, LoginException ;

    public Integer getTotalCostOfOrder(Integer id ,String key) throws SweetOrderException, LoginException ;

}
