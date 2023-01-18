package com.sweetmart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SweetItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderItemId;
	
	private SweetOrder sweetOrder;
	
	private Integer price;
	
	private String description;
	
	private Boolean available;

	public SweetItem(Integer orderItemId, SweetOrder sweetOrder, Integer price, String description, Boolean available) {
		super();
		this.orderItemId = orderItemId;
		this.sweetOrder = sweetOrder;
		this.price = price;
		this.description = description;
		this.available = available;
	}

	public SweetItem() {
		super();
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public SweetOrder getSweetOrder() {
		return sweetOrder;
	}

	public void setSweetOrder(SweetOrder sweetOrder) {
		this.sweetOrder = sweetOrder;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
	
	
}
