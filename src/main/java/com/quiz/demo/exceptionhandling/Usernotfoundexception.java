package com.quiz.demo.exceptionhandling;

public class Usernotfoundexception extends RuntimeException {
	String message;
	int id;

	public Usernotfoundexception(String message, int id) {
		super(message);

	}

	public int getid() {
		return id;
	}

	
}
