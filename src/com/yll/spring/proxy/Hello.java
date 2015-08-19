package com.yll.spring.proxy;

public class Hello implements IHello {

	@Override
	public void sayHello(String name) {
		System.out.println("hello word" + name);

	}

}
