package com.krishna.versioning;

public class person1 {
	private String name;

	@Override
	public String toString() {
		return "person1 [name=" + name + "]";
	}

	public person1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
