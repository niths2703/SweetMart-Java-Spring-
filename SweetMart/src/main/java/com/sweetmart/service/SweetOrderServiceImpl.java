package com.sweetmart.service;

import com.sweetmart.exception.LoginException;
import com.sweetmart.exception.SweetItemException;
import com.sweetmart.exception.SweetOrderException;
import com.sweetmart.model.CurrentUserSession;
import com.sweetmart.model.Customer;
import com.sweetmart.model.SweetItem;
import com.sweetmart.model.SweetOrder;
import com.sweetmart.repo.CustomerDao;
import com.sweetmart.repo.SessionDao;
import com.sweetmart.repo.SweetItemDao;
import com.sweetmart.repo.SweetOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SweetOrderServiceImpl implements SweetOrderService {

    @Autowired
    private SweetItemDao sweetdao;

    @Autowired
    private SessionDao sdao;


    @Autowired
    private SweetOrderDao sweetOrderDao;

    @Autowired
    private CustomerDao cDao;

    @Override
    public SweetOrder deleteSweetorderbyId(Integer id, String Customerkey) throws SweetOrderException, LoginException {

        if (Customerkey.length() != 4) {
            throw new LoginException("key is not valid ");
        }

        CurrentUserSession loginedcustomer = sdao.findByUuid(Customerkey);

        if (loginedcustomer == null) throw new LoginException("User Not logedin");

        else {
            Optional<Customer> customer = cDao.findById(loginedcustomer.getUserId());

            List<SweetOrder> sweetOrderList = customer.get().getSweetOrders();

            for (SweetOrder o :
                    sweetOrderList) {

                List<SweetItem> sweetItems = (List<SweetItem>) o.getSweetItems();


                if (o.getSweetOrderID() == id) {
                    sweetOrderDao.delete(o);
                    return o;
                }


            }

            throw new SweetOrderException("Order not found ");


        }
    }


    @Override
    public List<SweetOrder> getallSweetorder(String Customerkey) throws SweetOrderException, LoginException {

        if (Customerkey.length() != 4) {
            throw new LoginException("key is not valid ");
        }

        CurrentUserSession loginedcustomer = sdao.findByUuid(Customerkey);

        if (loginedcustomer == null) throw new LoginException("User Not logedin");

        else {
            Optional<Customer> customer = cDao.findById(loginedcustomer.getUserId());

            List<SweetOrder> sweetOrderList = customer.get().getSweetOrders();
            if (sweetOrderList.size() == 0) {
                throw new SweetItemException("not sweet item found by this customer ");
            }


            return sweetOrderList;
        }

    }


    @Override
    public Integer getTotalCostOfOrder(Integer id, String Customerkey) throws SweetOrderException, LoginException {


        if (Customerkey.length() != 4) {
            throw new LoginException("key is not valid ");
        }

        CurrentUserSession loginedcustomer = sdao.findByUuid(Customerkey);

        if (loginedcustomer == null) throw new LoginException("User Not logedin");

        else {
            Optional<Customer> customer = cDao.findById(loginedcustomer.getUserId());

            List<SweetOrder> sweetOrderList = customer.get().getSweetOrders();

            Integer totalCostOfOrder =  null ;
            for (SweetOrder o :
                    sweetOrderList) {


                if (o.getSweetOrderID() == id) {


                    List<SweetItem> sweetItems = (List<SweetItem>) o.getSweetItems();

                    for (SweetItem sItem :
                            sweetItems) {
                        Integer Quantity = sItem.getQuantity();

                        Integer price = sItem.getProduct().getPrice();



                        totalCostOfOrder = totalCostOfOrder + (Quantity*price) ;



                    }
                    return totalCostOfOrder ;

                }


            }
            throw new SweetOrderException("order not found ");

        }



    }



}
