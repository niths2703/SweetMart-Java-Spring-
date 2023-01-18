package com.sweetmart.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SweetOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer SweetOrderID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerID")
	private Customer customer;
	
	private List<SweetItem> sweetItems;
	
	private LocalDate createdDate;

	
	
	
	

}
