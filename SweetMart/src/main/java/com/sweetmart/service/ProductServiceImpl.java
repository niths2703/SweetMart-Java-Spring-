package com.sweetmart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetmart.exception.LoginException;
import com.sweetmart.exception.ProductException;
import com.sweetmart.model.CurrentUserSession;
import com.sweetmart.model.Customer;
import com.sweetmart.model.Product;
import com.sweetmart.repo.ProductDao;
import com.sweetmart.repo.SessionDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private SessionDao sdao;
	
	@Override
	public Product addProduct(String key, Product product) {
		  
		if (key.length() != 6) {

	            throw new LoginException("key is not valid ");

	        }

	        CurrentUserSession loginedcustomer = sdao.findByUuid(key);

	        if (loginedcustomer != null) {

	          return  productDao.save(product);
	        }
	        else {
	        	throw new LoginException("Admin not logged in");
	        }
	            
	            
		
	}

	@Override
	public Product updateProduct(String key, Product product) {
		if (key.length() != 6) {

            throw new LoginException("key is not valid ");

        }

        CurrentUserSession loginedcustomer = sdao.findByUuid(key);

        if (loginedcustomer != null) {

          return  productDao.save(product);
        }
        else {
        	throw new LoginException("Admin not logged in");
        }
            
	}

	@Override
	public Product deleteProductById(String key, Integer productId) {
		if (key.length() != 6) {

            throw new LoginException("key is not valid ");

        }

        CurrentUserSession loginedcustomer = sdao.findByUuid(key);
        

        if (loginedcustomer != null) {
           Optional<Product> op=productDao.findById(productId);
           
           if(op.isPresent()) {
        	   Product p=op.get();
        	   
        	  productDao.delete(p);
        	  
        	  return p;
        	   
           }
           else {
        	   throw new ProductException("Product Not found with id: "+ productId);
           }
         
        }
        else {
        	throw new LoginException("Admin not logged in");
        }
            
	}

}
