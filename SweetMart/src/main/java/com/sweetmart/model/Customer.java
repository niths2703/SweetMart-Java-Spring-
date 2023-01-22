package com.sweetmart.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	private int customerID;
	
	private String mobile;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userID")
	private User user;
	
	private String pass;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<SweetOrder> sweetOrders;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name ="cartId")
//	private Cart cart;
}
