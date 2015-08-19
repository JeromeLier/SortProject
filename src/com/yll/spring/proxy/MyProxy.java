package com.yll.spring.proxy;

public class MyProxy implements IHello {
	private IHello hello;
	public  MyProxy(IHello hello) {
		this.hello = hello;
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("begin proxy");
		hello.sayHello(name);
		System.out.println("end proxy");
	}

	public IHello getHello() {
		return hello;
	}
	
	

}
