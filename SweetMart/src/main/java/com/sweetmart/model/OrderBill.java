package com.sweetmart.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderBill {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer orderBillId;
	

	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="sweetOrderId")
	private SweetOrder sweetOrders;
	
	
	
	private Integer totalPrice;

	
	
	
}
