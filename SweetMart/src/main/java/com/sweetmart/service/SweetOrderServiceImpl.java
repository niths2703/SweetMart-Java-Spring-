package com.sweetmart.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetmart.dto.ProductQuantityDTO;
import com.sweetmart.dto.SweetOrderDTO;
import com.sweetmart.exception.OrderBillException;
import com.sweetmart.exception.SweetOrderException;
import com.sweetmart.model.Customer;
import com.sweetmart.model.Product;
import com.sweetmart.model.SweetItem;
import com.sweetmart.model.SweetOrder;
import com.sweetmart.model.User;
import com.sweetmart.repo.CustomerDao;
import com.sweetmart.repo.ProductDao;
import com.sweetmart.repo.SweetItemDao;
import com.sweetmart.repo.SweetOrderDao;

@Service

public class SweetOrderServiceImpl implements SweetOrderService {
	
	  @Autowired
	  private ProductDao productDao;
	  
	  
	  @Autowired
	  private CustomerDao customerDao;
	  
	  
	  @Autowired
	  private SweetOrderDao sweetOrderDao;
	  
	  
	  @Autowired
	  private SweetItemDao sweetItemDao;

	@Override
	public SweetOrder createSweetOrderService(User user, SweetOrderDTO sweetOrderDTO) throws SweetOrderException {
		// TODO Auto-generated method stub
		      // create sweet Item list using Product id and quantity
		
		   List<ProductQuantityDTO>   pqs =  sweetOrderDTO.getProductQuantityDTO();
		    
		    List<SweetItem>  sweetItems = new ArrayList<>();
		   for(ProductQuantityDTO pq : pqs) {
			         Optional<Product>  opt =  productDao.findById(pq.getProductId());
			         
			         if(opt.isPresent()) {
			        	 SweetItem sweetItem = new SweetItem();
					        sweetItem.setQuantity(pq.getQuantity());
					        sweetItem.setProduct(opt.get());
					        
					        sweetItems.add(sweetItem);
					        
			         }else {
			        	 throw new SweetOrderException("There is no product with id :"+ pq.getProductId());
			         }
			         
		   }
		   
		   
		   
		   // get customer form user
		       Optional<Customer>  opt =       customerDao.findByUserId(user.getUserID());
		       if(opt.isPresent()) {
		    	   SweetOrder sweetOrder = new SweetOrder();
		    	   sweetOrder.setCustomer(opt.get());
		    	   sweetOrder.setOrderedDate(LocalDateTime.now());
		    	   sweetOrder.setSweetItems(sweetItems);
		    	  
		         sweetOrder =   sweetOrderDao.save(sweetOrder);
		         
		         for(SweetItem sweetItem : sweetItems) {
		        	        sweetItem.setSweetOrder(sweetOrder);
		        	        sweetItemDao.save(sweetItem);
		         }
		    	   
		    	  return sweetOrder;
		    	   
		    	   
		       }else {
		    	   throw new SweetOrderException("Only customer can order");
		       }
		   
		
		
	}

	@Override
	public SweetOrder updateNewSweetItemInSweetOrderService(User user, SweetOrderDTO sweetOrderDTO)
			throws SweetOrderException {
		// TODO Auto-generated method stub

		   List<ProductQuantityDTO>   pqs =  sweetOrderDTO.getProductQuantityDTO();
		    
		    List<SweetItem>  sweetItems = new ArrayList<>();
		   for(ProductQuantityDTO pq : pqs) {
			         Optional<Product>  opt =  productDao.findById(pq.getProductId());
			         
			         if(opt.isPresent()) {
			        	 SweetItem sweetItem = new SweetItem();
					        sweetItem.setQuantity(pq.getQuantity());
					        sweetItem.setProduct(opt.get());
					        
					        sweetItems.add(sweetItem);
					        
			         }else {
			        	 throw new SweetOrderException("There is no product with id :"+ pq.getProductId());
			         }
			         
		   }
		   
		   
		   //   Add to exiting SweetOrder
		    Optional<SweetOrder>  opt =  sweetOrderDao.findById(sweetOrderDTO.getSweetOrderId());
		           
		     if(opt.isPresent()) {
		    	     SweetOrder sweetOrder =   opt.get();
		    	     
		    	       for(SweetItem sweetItem: sweetItems) {
		    	    	       sweetItem.setSweetOrder(sweetOrder);
		    	    	       sweetItemDao.save(sweetItem);
		    	       }
		    	       
		    	     return sweetOrder;
		    	     
		     }else {
		    	   throw new SweetOrderException("Order is not there with id:" + sweetOrderDTO.getSweetOrderId());
		     }
		
		
		
	}
	
	
	  
	

//    @Autowired
//    private SweetItemDao sweetdao;
//
//    @Autowired
//    private SessionDao sdao;
//
//
//    @Autowired
//    private SweetOrderDao sweetOrderDao;
//
//    @Autowired
//    private CustomerDao cDao;
//
//    @Override
//    public SweetOrder deleteSweetorderbyId(Integer id, String Customerkey) throws SweetOrderException, LoginException {
//
//        if (Customerkey.length() != 4) {
//            throw new LoginException("key is not valid ");
//        }
//
//        CurrentUserSession loginedcustomer = sdao.findByUuid(Customerkey);
//
//        if (loginedcustomer == null) throw new LoginException("User Not logedin");
//
//        else {
//            Optional<Customer> customer = cDao.findById(loginedcustomer.getUserId());
//
//            List<SweetOrder> sweetOrderList = customer.get().getSweetOrders();
//
//            for (SweetOrder o :
//                    sweetOrderList) {
//
//                List<SweetItem> sweetItems = (List<SweetItem>) o.getSweetItems();
//
//
//                if (o.getSweetOrderID() == id) {
//                    sweetOrderDao.delete(o);
//                    return o;
//                }
//
//
//            }
//
//            throw new SweetOrderException("Order not found ");
//
//
//        }
//    }
//
//
//    @Override
//    public List<SweetOrder> getallSweetorder(String Customerkey) throws SweetOrderException, LoginException {
//
//        if (Customerkey.length() != 4) {
//            throw new LoginException("key is not valid ");
//        }
//
//        CurrentUserSession loginedcustomer = sdao.findByUuid(Customerkey);
//
//        if (loginedcustomer == null) throw new LoginException("User Not logedin");
//
//        else {
//            Optional<Customer> customer = cDao.findById(loginedcustomer.getUserId());
//
//            List<SweetOrder> sweetOrderList = customer.get().getSweetOrders();
//            if (sweetOrderList.size() == 0) {
//                throw new SweetItemException("not sweet item found by this customer ");
//            }
//
//
//            return sweetOrderList;
//        }
//
//    }
//
//
//    @Override
//    public Integer getTotalCostOfOrder(Integer id, String Customerkey) throws SweetOrderException, LoginException {
//
//
//        if (Customerkey.length() != 4) {
//            throw new LoginException("key is not valid ");
//        }
//
//        CurrentUserSession loginedcustomer = sdao.findByUuid(Customerkey);
//
//        if (loginedcustomer == null) throw new LoginException("User Not logedin");
//
//        else {
//            Optional<Customer> customer = cDao.findById(loginedcustomer.getUserId());
//
//            List<SweetOrder> sweetOrderList = customer.get().getSweetOrders();
//
//            Integer totalCostOfOrder =  null ;
//            for (SweetOrder o :
//                    sweetOrderList) {
//
//
//                if (o.getSweetOrderID() == id) {
//
//
//                    List<SweetItem> sweetItems = (List<SweetItem>) o.getSweetItems();
//
//                    for (SweetItem sItem :
//                            sweetItems) {
//                        Integer Quantity = sItem.getQuantity();
//
//                        Integer price = sItem.getProduct().getPrice();
//
//
//
//                        totalCostOfOrder = totalCostOfOrder + (Quantity*price) ;
//
//
//
//                    }
//                    return totalCostOfOrder ;
//
//                }
//
//
//            }
//            throw new SweetOrderException("order not found ");
//
//        }
//
//
//
//    }



}
