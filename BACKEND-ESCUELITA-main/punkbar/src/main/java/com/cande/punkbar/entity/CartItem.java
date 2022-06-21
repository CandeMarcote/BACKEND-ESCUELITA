package com.cande.punkbar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart_item")
public class CartItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="product_number")
	private int productNumber;
	
	@Column(name="quantity")
	private int quantity;

	@Column(name="category")
	private String category;
	
	@Column(name="cart_id")
	private int cartId;
	
	public CartItem() {}

	public CartItem(int productNumber, int quantity, String category, int userId) {
		this.productNumber = productNumber;
		this.quantity = quantity;
		this.category = category;
		this.cartId = userId;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int userId) {
		this.cartId = userId;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", productNumber=" + productNumber + ", quantity=" + quantity + ", category="
				+ category + ", userId=" + cartId + "]";
	}
}
