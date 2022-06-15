package com.cande.punkbar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favorites")
public class Favorite {

	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="product_number")
	private int productNumber;
	
	@Column(name="category")
	private String category;
	
	@Column(name="user_id")
	private int userId;
	
	//define constructors
	public Favorite() {}

	public Favorite(int produtctNumber, String category, int userId) {
		this.productNumber = produtctNumber;
		this.category = category;
		this.userId = userId;
	}
	
	
	//define getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProdutctNumber() {
		return productNumber;
	}

	public void setProdutctNumber(int produtctNumber) {
		this.productNumber = produtctNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	//define a toString method

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", produtctNumber=" + productNumber + ", category=" + category + ", userId=" + userId
				+ "]";
	}
}
