package com.sweetmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userID;
	
	@NotNull(message = "UserName Mandatory")
	@NotEmpty(message = "Provide some valid UserName")
	@Size(min = 5,max = 10,message = "userName size must be max:5 min:10")
	private String username;
	
	@NotNull(message = "Password Mandatory")
	@NotEmpty(message = "Provide some valid Password")
	@Size(min = 5,max = 10,message = "Password size must be max:5 min:10")
	private String password;
	
	@NotNull(message = "passwordConfirm Mandatory")
	@NotEmpty(message = "Provide some valid passwordConfirm")
	@Size(min = 5,max = 10,message = "passwordConfirm size must be max:5 min:10")
	private String passwordConfirm;
	
	@NotNull(message = "mobile Mandatory")
	@NotEmpty(message = "Provide some valid mobile")
	@Column(unique = true)
	@Size(min = 10,max = 10,message = "Enter Valid Mobile Number")
	private String mobile;
	
//	@NotNull(message = "type Mandatory")
//	@NotEmpty(message = "Provide some valid type`")
//	@Size(min = 5,max = 8,message = "type size must be max:5 min:8")
	private type type;

	public User(String username, String password, String passwordConfirm,
			@Size(min = 10, max = 10, message = "Enter Valid Mobile Number") String mobile,
			com.sweetmart.model.type type) {
		super();
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.mobile = mobile;
		this.type = type;
	}
}
