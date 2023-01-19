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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Default;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cartId;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="sweetItemId")
	private List<SweetOrder> sweetOrders;
   
	private Integer totalPrice;
	
	@Value("false")
	private boolean isCheckout;
}
