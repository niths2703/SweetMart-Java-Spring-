package com.sweetmart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SweetItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sweetItemId;

	private Integer quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "productId")
	private Product product;

	
	
	
}
