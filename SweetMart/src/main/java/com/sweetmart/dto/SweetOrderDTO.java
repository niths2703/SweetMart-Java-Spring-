package com.sweetmart.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SweetOrderDTO {
       
	
	
	private String key;
	
	
//	@JsonAlias("productslist")
	private List<ProductQuantityDTO>  productQuantityDTO = new ArrayList<>();
	
	private Integer sweetOrderId; 
	
 //  	@JsonAlias("sweetItemQuantity")
	private SweetItemQuantityDTO sweetItemQUantityDTO;
}
