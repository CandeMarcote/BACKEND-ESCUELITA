package com.cande.punkbar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductTest {

	@Id
	@Column(name="id_product")
	private int idProduct;
	
	@Column(name="name")
	private String name;
	
	@Column(name="id_category")
	private String idCategory;
	
	@Column(name="price")
	private int price;
}
