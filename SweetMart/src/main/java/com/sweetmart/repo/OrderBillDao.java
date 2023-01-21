package com.sweetmart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweetmart.model.OrderBill;

public interface OrderBillDao extends JpaRepository<OrderBill, Integer> {

}
