package com.krishna.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class customexception extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Errordetails> handleAllException(Exception ex, WebRequest request) throws Exception {
		Errordetails er = new Errordetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Errordetails>(er,HttpStatus.INTERNAL_SERVER_ERROR);

	}
	@Override 
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
			Errordetails er = new Errordetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
			return new ResponseEntity(er,HttpStatus.BAD_REQUEST);
	}
}
