package com.sweetmart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Administrator {

	@Id
	private Integer id;
	
	@Column(unique = true)
	@Size(min = 10,max = 10,message = "Enter Valid Mobile Number")
	private String mobile;
	
	@Size(min = 5,max = 10,message = "Enter Valid Password")
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	private User  user;	
}
