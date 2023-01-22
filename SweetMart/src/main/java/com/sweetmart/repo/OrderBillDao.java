package com.sweetmart.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweetmart.model.OrderBill;
import com.sweetmart.model.SweetOrder;

public interface OrderBillDao extends JpaRepository<OrderBill, Integer> {
      
	
	      public Optional<OrderBill>  findBySweetOrders(SweetOrder sweetOrder);
}
