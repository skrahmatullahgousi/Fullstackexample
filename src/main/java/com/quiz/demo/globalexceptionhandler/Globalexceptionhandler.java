package com.quiz.demo.globalexceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.quiz.demo.exceptionhandling.Usernotfoundexception;

@RestControllerAdvice
public class Globalexceptionhandler {
	@ExceptionHandler(Usernotfoundexception.class)
	public ResponseEntity<Usernotfoundexception> handling(Usernotfoundexception e) {
	
		Usernotfoundexception result = new Usernotfoundexception(e.getMessage(), e.getid());
		return ResponseEntity.status(404).body(result);
	}
}
