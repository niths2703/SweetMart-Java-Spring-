package com.sweetmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private String username;
	
	private String password;
	
	private String passwordConfirm;
	
	@Column(unique = true)
	@Size(min = 10,max = 10,message = "Enter Valid Mobile Number")
	private String mobile;
	
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
