package com.yll.design.proxyDesgin;

public class ProxyTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �����ô��� ��Ҫ����ServiceImpl�в�������Ĵ��� �����ƵĴ�����
		//Service service = new ServiceImpl();
		// ʹ�ô���
		Service service = (Service)new MyProxy().bind(new ServiceImpl());
		service.sayHello();
		service.sayBye();
		service.sayHi();
	}

}
