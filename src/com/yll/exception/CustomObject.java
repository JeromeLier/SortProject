package com.yll.exception;

import java.util.HashMap;

public class CustomObject extends HashMap {

	private static final long serialVersionUID = 5176739397156548105L;

	private String message;

	public CustomObject(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}