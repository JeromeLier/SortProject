package com.yll.thread;

public class KeyPersonThread extends Thread {

	public void run() {
		System.out.println(Thread.currentThread().getName() +"��ʼ��ս��");
		for (int i = 0; i< 5; i++) {
			System.out.println(Thread.currentThread().getName() +" ��ɱ���  [" + i + "]");
			// �����ó��˴�����ʱ��
			Thread.yield();
		}
		System.out.println(Thread.currentThread().getName() +"������ս��");
		
	}
	
}
