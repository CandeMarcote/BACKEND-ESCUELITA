package com.cande.punkbar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryTest {

	@Id
	@Column(name="id_category")
	private int idCategory;
	
	@Column(name="type")
	private String type;

	public CategoryTest(int idCategory, String type) {
		this.idCategory = idCategory;
		this.type = type;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CategoryTest [idCategory=" + idCategory + ", type=" + type + "]";
	}
	
}
