package com.cande.punkbar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_test")
public class OrderTest {

	@Id
	@Column(name="id_order")
	private int idOrder;
	
	@Column(name="id_user")
	private int idUser;
	
	@Column(name="delivered")
	private Boolean delivered;
	
	public OrderTest() {
		
	}

	public Boolean getDelivered() {
		return delivered;
	}

	public void setDelivered(Boolean delivered) {
		this.delivered = delivered;
	}

	public OrderTest(int idOrder, int idUser, Boolean delivered) {
		this.idOrder = idOrder;
		this.idUser = idUser;
		this.delivered = delivered;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	@Override
	public String toString() {
		return "OrderTest [idOrder=" + idOrder + ", idUser=" + idUser + ", delivered=" + delivered + "]";
	}
	
}
