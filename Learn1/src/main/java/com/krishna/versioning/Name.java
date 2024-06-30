package com.krishna.versioning;

public class Name {
	private String fname;
	private String lname;
	public Name(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	@Override
	public String toString() {
		return "Name [fname=" + fname + ", lname=" + lname + "]";
	}
	
	

}
