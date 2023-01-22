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
					        
					           sweetItem = sweetItemDao.save(sweetItem);
					        sweetItems.add(sweetItem);
			         }else {
			        	 throw new SweetOrderException("There is no product with id :"+ pq.getProductId());
			         }
			         
		   }
		   
		   
		   
		   // get customer form user
		       Optional<Customer>  opt =   customerDao.findByUser(user);
		          System.out.println(opt.get().getMobile());
		       if(opt.isPresent()) {
		    	   SweetOrder sweetOrder = new SweetOrder();
		    	   sweetOrder.setCustomer(opt.get());
		    	   sweetOrder.setOrderedDate(LocalDateTime.now());
		    	   sweetOrder.setSweetItems(sweetItems);
		    	  
		         sweetOrder =   sweetOrderDao.save(sweetOrder);
		         
		    	   
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
		   
		   //  check for particular sweetOrder
		   Optional<SweetOrder>  opt =  sweetOrderDao.findById(sweetOrderDTO.getSweetOrderId());
           
		     if(opt.isPresent()) {
		    	     SweetOrder sweetOrder =   opt.get();
		    	     
		    	     
		    	     
		    	     List<SweetItem>  sweetItems = sweetOrder.getSweetItems();
		  		   for(ProductQuantityDTO pq : pqs) {
		  			         Optional<Product>  opt1 =  productDao.findById(pq.getProductId());
		  			         
		  			         if(opt1.isPresent()) {
		  			        	 SweetItem sweetItem = new SweetItem();
		  					        sweetItem.setQuantity(pq.getQuantity());
		  					        sweetItem.setProduct(opt1.get());
		  					         sweetItem =  sweetItemDao.save(sweetItem);
		  					        sweetItems.add(sweetItem);
		  					        
		  			         }else {
		  			        	 throw new SweetOrderException("There is no product with id :"+ pq.getProductId());
		  			         }
		  			         
		  		   }
		    	     
		    	     
		    	     return sweetOrderDao.save(sweetOrder);
		    	     
		     }else {
		    	   throw new SweetOrderException("Order is not there with id:" + sweetOrderDTO.getSweetOrderId());
		     }
		    
		  
		   
		   
		   
		  
		
		
		
	}

	@Override
	public SweetOrder updateQuantityOfSweetItemsInSweetOrderService(User user, SweetOrderDTO sweetOrderDTO)
			throws SweetOrderException {
		// TODO Auto-generated method stub
		
		// check for sweetOrder
		       Optional<SweetOrder>  opt =       sweetOrderDao.findById(sweetOrderDTO.getSweetOrderId());
		
		      if(opt.isPresent()) {
		    	    SweetOrder sweetOrder =   opt.get();
		    	    
		    	    List<SweetItem> sweetItems = sweetOrder.getSweetItems();
		    	    boolean flag = false;
		    	    for(SweetItem sweetItem: sweetItems) {
		    	    	    if(sweetItem.getSweetItemId() == sweetOrderDTO.getSweetItemQUantityDTO().getSweetItemId()) {
		    	    	    	sweetItem.setQuantity(sweetOrderDTO.getSweetItemQUantityDTO().getQuantity());
		    	    	    	sweetItemDao.save(sweetItem);
		    	    	    	flag = true;
		    	    	    	break;
		    	    	    }
		    	    }
		    	    
		    	    if(flag) { 
		    	    	
		    	    	  return sweetOrderDao.save(sweetOrder);
		    	    }else {
		    	    	 throw new SweetOrderException("There is no sweet Itwm with this id"+sweetOrderDTO.getSweetItemQUantityDTO().getSweetItemId());
		    	    }
		      }else {
		    	    throw new SweetOrderException("There is no sweet order sweet id :"+sweetOrderDTO.getSweetOrderId());
		      }
		
	}

	@Override
	public SweetOrder deleteSweetOrderService(User user, SweetOrderDTO sweetOrderDTO) throws SweetOrderException {
		// TODO Auto-generated method stub
		
		      // check for sweetORder
		        Optional<SweetOrder> opt =    sweetOrderDao.findById(sweetOrderDTO.getSweetOrderId());
		        
		        if(opt.isPresent()) {
		        	  SweetOrder    sweetOrder = opt.get();  
		        	    
		        	  
		        	  //verify that is this order belongs to this user
		        	 if( sweetOrder.getCustomer().getUser().getUserID() == user.getUserID()) {
		        		 
		        		 // check if order is placed or not 
		        		     // if placed then it is impossible to delete
		        		   if(sweetOrder.getIsOrderPalced()) {
		        			     throw new SweetOrderException("impossible to delete, Sweet Order is orderd and it is in delivery process");
		        		   }
		        		     List<SweetItem> sweetItems =     sweetOrder.getSweetItems();
		        		     
		        		    
		        		         sweetOrder.setSweetItems(null);
		        		         sweetOrder.setCustomer(null);
		        		      
		        		         for(SweetItem sweetItem : sweetItems) {
		        		        	    sweetItem.setProduct(null);
		        		        	    sweetItemDao.delete(sweetItem);
		        		         }
		        		         
		        		         
		        		      sweetOrderDao.delete(sweetOrder);
		        		      
		        		      return sweetOrder;
		        		        
		        	 }else {
		        		 throw new SweetOrderException("This sweet order is not belongs to you");
		        	 }
		        }else {
		        	throw new SweetOrderException("There is no sweet order with id: "+sweetOrderDTO.getSweetOrderId());
		        }
		
		  
		
		
		
	}
	
	
	 
}
