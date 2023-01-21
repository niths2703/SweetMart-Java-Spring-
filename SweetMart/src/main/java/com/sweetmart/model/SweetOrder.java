package com.sweetmart.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SweetOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer SweetOrderID;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerID")
	private Customer customer;


	@OneToMany(cascade= CascadeType.ALL, mappedBy="sweetOrder")
	private List<SweetItem> sweetItems ;

	private LocalDate orderedDate;


//	@Value("false")
//	private boolean isCheckout;




}
