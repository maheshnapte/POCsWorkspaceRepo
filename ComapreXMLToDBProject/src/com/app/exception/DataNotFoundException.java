package com.app.exception;

public class DataNotFoundException extends Exception{

	public DataNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Data Not Found Exception");
	}
	
	public DataNotFoundException(String str) {
		// TODO Auto-generated constructor stub
		super(str);
	}
}
