package com.yll.exception;

public class ExtCustomException extends Exception  {

	private static final long serialVersionUID = -6879298763723247455L;
	private String    message;
	
	public ExtCustomException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	 @Override
     public Throwable fillInStackTrace() {
	   return this;
	       }
}
