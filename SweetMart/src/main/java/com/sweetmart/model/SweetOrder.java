package com.sweetmart.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer SweetOrderID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerID")
	private Customer customer;
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="sweetOrder")
	private Set<SweetItem> sweetItems = new HashSet<>();
	
	private LocalDate orderedDate;

	
	
	
	

}
