package com.sweetmart.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderBill {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderBillId;
	
	private LocalDate createdDate;
	
	private Float totalCost;
	
	private List<SweetOrder> sweetOrders;

	public OrderBill(Integer orderBillId, LocalDate createdDate, Float totalCost, List<SweetOrder> sweetOrders) {
		super();
		this.orderBillId = orderBillId;
		this.createdDate = createdDate;
		this.totalCost = totalCost;
		this.sweetOrders = sweetOrders;
	}

	public OrderBill() {
		super();
	}

	public Integer getOrderBillId() {
		return orderBillId;
	}

	public void setOrderBillId(Integer orderBillId) {
		this.orderBillId = orderBillId;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public List<SweetOrder> getSweetOrders() {
		return sweetOrders;
	}

	public void setSweetOrders(List<SweetOrder> sweetOrders) {
		this.sweetOrders = sweetOrders;
	}
	
	
	
}
