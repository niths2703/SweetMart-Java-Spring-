package com.sweetmart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Administrator {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	private User  user;

	
	
	
	
}
