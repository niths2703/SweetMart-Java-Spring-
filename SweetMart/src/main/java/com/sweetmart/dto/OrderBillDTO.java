package com.sweetmart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderBillDTO {
      
	
	private String key;
	
	private Integer sweetOrderId;
	
	private Integer ordderId;
}
