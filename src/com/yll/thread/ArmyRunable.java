package com.yll.thread;

public class ArmyRunable implements Runnable{

	volatile boolean keepRuning = true;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(keepRuning) {
			for (int i = 0; i< 5; i++) {
				System.out.println(Thread.currentThread().getName() +"�����Է�[" + i + "]");
				// �����ó��˴�����ʱ��
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName() + "����ս��");
		
	}

}
