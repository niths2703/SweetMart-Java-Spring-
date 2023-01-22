package com.sweetmart.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SweetOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer SweetOrderID;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerID")
	private Customer customer;


	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name= "sweetOrderID")
	private List<SweetItem> sweetItems;

	private LocalDateTime orderedDate;
	
	
	private Boolean  isOrderPalced= false;


//	@Value("false")
//	private boolean isCheckout;




}
