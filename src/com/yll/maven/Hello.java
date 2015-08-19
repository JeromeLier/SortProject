package com.yll.maven;

public class Hello {

	private int hel;
	private String getHelloString;
	
	
	Hello () {
		this.hel = 5;
		this.getHelloString = "domain";
	}
	
	public void printGetHell(){
		
		System.out.println("this is" + getHelloString);
	}
	
	public static void main(String[] args) {
		
		int a = 0;
		double b = 0.00;
		if(a == b) {
			System.out.println("good");
		} else {
			System.out.println("false ");
		}
	}
	
	
	
}
