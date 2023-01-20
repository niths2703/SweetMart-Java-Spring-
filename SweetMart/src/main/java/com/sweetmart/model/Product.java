package com.sweetmart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer productId;
	  
	  private String productName;
	  
	  private Integer price;
	  
		  private String ingradient;
	  
}
