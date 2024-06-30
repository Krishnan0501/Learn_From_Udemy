package com.krishna.Filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties("field1")
@JsonFilter("somebeanfilter")
public class Bean {
	//@JsonIgnore
	private String field1;
	private String field2;
	private String field3;
	@Override
	public String toString() {
		return "Bean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	public Bean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	public String getField1() {
		return field1;
	}
	public String getField2() {
		return field2;
	}
	public String getField3() {
		return field3;
	}
	

}
