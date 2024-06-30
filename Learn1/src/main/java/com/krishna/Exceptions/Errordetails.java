package com.krishna.Exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Errordetails {
	private LocalDateTime localtime;
	private String message;
	private String details;
	public Errordetails(LocalDateTime localtime, String message, String details) {
		super();
		this.localtime = localtime;
		this.message = message;
		this.details = details;
	}
	public LocalDateTime getLocaltime() {
		return localtime;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	

}
