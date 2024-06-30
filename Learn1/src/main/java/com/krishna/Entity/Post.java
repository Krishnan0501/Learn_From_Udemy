package com.krishna.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
@Entity
public class Post {
	@Id
	@GeneratedValue
	private int id;
	@Size (min=2)
	private String decsription;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	public Post(int id, String decsription, User user) {
		super();
		this.id = id;
		this.decsription = decsription;
		this.user = user;
	}
	
	public Post() {
		super();
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", decsription=" + decsription + ", user=" + user + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDecsription() {
		return decsription;
	}
	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
