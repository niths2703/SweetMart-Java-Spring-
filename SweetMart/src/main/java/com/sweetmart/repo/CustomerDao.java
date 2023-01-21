package com.sweetmart.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sweetmart.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer>{
	
	
	
	    public Optional<Customer> findByUserId(Integer id);
	

}
