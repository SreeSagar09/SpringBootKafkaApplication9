package com.app.model;

import java.util.Date;
import java.util.List;

public class Order {
	private String orderId;
	private String orderName;
	private List<String> items;
	private Date orderDate;
	private String deliverTo;
	private String orderProcessedBy;
	
	public Order() {
		super();
	}

	public Order(String orderId, String orderName, List<String> items, Date orderDate, String deliverTo, String orderProcessedBy) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.items = items;
		this.orderDate = orderDate;
		this.deliverTo = deliverTo;
		this.orderProcessedBy = orderProcessedBy;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliverTo() {
		return deliverTo;
	}

	public void setDeliverTo(String deliverTo) {
		this.deliverTo = deliverTo;
	}
	
	public String getOrderProcessedBy() {
		return orderProcessedBy;
	}

	public void setOrderProcessedBy(String orderProcessedBy) {
		this.orderProcessedBy = orderProcessedBy;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", items=" + items + ", orderDate="
				+ orderDate + ", deliverTo=" + deliverTo + ", orderProcessedBy=" + orderProcessedBy + "]";
	}
	
}
