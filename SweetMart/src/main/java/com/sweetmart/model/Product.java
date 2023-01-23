package com.sweetmart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer productId;
	  
	  @Size(min = 5,max = 10,message = "Enter Valid Name")
	  @NotNull(message = "Product Name Mandatory")
	  @NotEmpty(message = "Provide some valid ProductName")
	  private String productName;
	  
	  @Min(10)
//	  @NotNull(message = "price Mandatory")
//	  @NotEmpty(message = "Provide some valid price")
	  private Integer price;
	  
	  @Size(min = 5,max = 20,message = "ingradient size max:5 min:20")
	  @NotNull(message = "ingradient Mandatory")
	  @NotEmpty(message = "Provide some valid ingradient")
	  private String ingradient;
}
