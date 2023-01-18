package com.sweetmart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cartId;
	   
	private double grandTotal;
	
	private List<SweetItem> sweetItems;
   
	private Integer sweetItemsConut;
   
	private Integer total;

	public Cart(Integer cartId, double grandTotal, List<SweetItem> sweetItems, Integer sweetItemsConut, Integer total) {
		super();
		this.cartId = cartId;
		this.grandTotal = grandTotal;
		this.sweetItems = sweetItems;
		this.sweetItemsConut = sweetItemsConut;
		this.total = total;
	}

	public Cart() {
		super();
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<SweetItem> getSweetItems() {
		return sweetItems;
	}

	public void setSweetItems(List<SweetItem> sweetItems) {
		this.sweetItems = sweetItems;
	}

	public Integer getSweetItemsConut() {
		return sweetItemsConut;
	}

	public void setSweetItemsConut(Integer sweetItemsConut) {
		this.sweetItemsConut = sweetItemsConut;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
   
   
	
	
}
