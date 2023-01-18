package com.sweetmart.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerID;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userID")
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<SweetOrder> sweetOrders;
	
	
	private Cart cart;

	
	
	
	
}
