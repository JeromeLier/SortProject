package com.yll.design.proxyDesgin;

public class ProxyTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 不启用代理 需要在类ServiceImpl中插入冗余的代码 被猪似的代码行
		//Service service = new ServiceImpl();
		// 使用代理
		Service service = (Service)new MyProxy().bind(new ServiceImpl());
		service.sayHello();
		service.sayBye();
		service.sayHi();
	}

}
