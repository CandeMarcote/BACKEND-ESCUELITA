package com.cande.punkbar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favorite")
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
	
	@Column(name="name")
	private String name;
	
	@Column(name="user_id")
	private int userId;
	
	//define constructors
	public Favorite() {}


	public Favorite(int productNumber, String category, String name, int userId) {
		this.productNumber = productNumber;
		this.category = category;
		this.name = name;
		this.userId = userId;
	}


	//define getters and setters

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

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
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
		return "Favorite [id=" + id + ", productNumber=" + productNumber + ", category=" + category + ", name=" + name
				+ ", userId=" + userId + "]";
	}

}
