package com.krishna.controller.model;

import org.springframework.stereotype.Component;
@Component
public class HelloBean {
	private String message;

	public HelloBean() {
		super();
	}

	public HelloBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloBean [message=" + message + "]";
	}

}
