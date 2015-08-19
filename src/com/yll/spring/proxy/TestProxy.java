package com.yll.spring.proxy;

public class TestProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IHello hello = new MyProxy(new Hello());
		hello.sayHello(" John");
		
		IHello hello1 = new Hello();
		hello1.sayHello(" mac");

	}

}
