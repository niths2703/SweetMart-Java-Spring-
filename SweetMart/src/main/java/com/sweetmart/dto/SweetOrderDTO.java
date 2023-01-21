package com.sweetmart.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SweetOrderDTO {
       
	
	
	private String key;
	
	private List<ProductQuantityDTO>  productQuantityDTO = new ArrayList<>();
	
	private Integer sweetOrderId; 
}
