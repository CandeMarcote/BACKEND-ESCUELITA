package com.cande.punkbar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_detail_test")
public class OrderDetailTest {

	@Id
	@Column(name="id_order")
	private int idOrder;
	
	@Column(name="id_product")
	private int idProduct;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="price")
	private int price;

	public OrderDetailTest(int idOrder, int idProduct, int amount, int price) {
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.amount = amount;
		this.price = price;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetailTest [idOrder=" + idOrder + ", idProduct=" + idProduct + ", amount=" + amount + ", price="
				+ price + "]";
	}
	
}
