package com.miniproject.quiz.java;

public class ExceptionId extends RuntimeException {
	// creating custom Exception class
	
	String message ;
	ExceptionId(String message){
		super(message);
}
}

