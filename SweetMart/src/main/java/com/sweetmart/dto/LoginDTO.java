package com.sweetmart.dto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginDTO {
	
	@NotNull(message = "mobile Mandatory")
	@NotEmpty(message = "Provide some valid mobile")
	@Size(min = 10,max = 10,message = "Enter Valid Mobile Number")
	private String mobile;
	
	@NotNull(message = "Password Mandatory")
	@NotEmpty(message = "Provide some valid Password")
	@Size(min = 5,max = 10,message = "Password size must be max:5 min:10")
	private String password;
	
	@NotNull(message = "type Mandatory")
	@NotEmpty(message = "Provide some valid type`")
	@Size(min = 5,max = 8,message = "type size must be max:5 min:8")
	private String type;
}
