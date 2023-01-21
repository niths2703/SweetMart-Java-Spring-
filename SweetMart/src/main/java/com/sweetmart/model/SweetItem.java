package com.sweetmart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


	private Integer quantity;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="sweetOrderId")
	private SweetOrder sweetOrder;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "productId")
	private Product product;	
}
