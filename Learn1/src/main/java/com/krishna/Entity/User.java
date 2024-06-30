package com.krishna.Entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	@Id
	private int id;
	@Size(min=2,message="name should be atleast two character above")
	private String name;
	@Past(message="should be past")
	private LocalDate DOB;
	@OneToMany(mappedBy = "user")
	private List<Post> post;
	public User() {
		super();
	}
	public User(int id, String name, LocalDate dOB) {
		super();
		this.id = id;
		this.name = name;
		DOB = dOB;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", DOB=" + DOB + "]";
	}
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	
	
	

}
