package com.yll.memchache;

import java.io.Serializable;

/**
 * Oct 15, 2011
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1003272426055966138L;
	private String userName;
	private String email;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

