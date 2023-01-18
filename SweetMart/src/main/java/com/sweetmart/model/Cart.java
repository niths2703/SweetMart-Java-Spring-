package com.sweetmart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cartId;
	
	
	
	@OneToOne(cascade=CascadeType.ALL)
	private Customer customer;
	
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="sweetItemId")
	private List<SweetItem> sweetItems;
   
	
	
	private Integer totalPrice;
	

	
   
   
	
	
}
