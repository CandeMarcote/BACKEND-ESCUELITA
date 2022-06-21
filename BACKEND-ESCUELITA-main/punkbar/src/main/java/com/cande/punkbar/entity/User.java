package com.cande.punkbar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="user_favorite")
	private List<Favorite> favorites;
	/*private CartItem;
	private OrderItem;*/
	

	//define constructors
	public User() {}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	//define getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
	
	//convenience method for adding favorites
	
	public void add(Favorite favorite) {
		if(favorites == null) {
			favorites = new ArrayList<>();
		}
		
		favorites.add(favorite);
	}
	
	//define a toString method
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}	
}
