package com.sweetmart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SweetItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sweetItemId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sweetOrderId")
	private SweetOrder sweetOrder;
	
	

	private Integer quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "productId")
	private Product product;

	
	
	
}
