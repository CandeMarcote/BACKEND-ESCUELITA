package com.cande.punkbar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="product_number")
	private int productNumber;
	
	@Column(name="category")
	private String category;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="user_id")
	private int userId;
	
	public OrderItem() {}

	public OrderItem(int productNumber, String category, int quantity, int userId) {
		this.productNumber = productNumber;
		this.category = category;
		this.quantity = quantity;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", productNumber=" + productNumber + ", category=" + category + ", quantity="
				+ quantity + ", userId=" + userId + "]";
	}

}
