package com.yll.thread;


public class Stage extends Thread {

	
	public void run() {
		System.out.println("_________________��ʼ�ۿ���������____________");
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("_________________������ʼ �����ũ���������ʼ��֤____________");
		
		ArmyRunable armyTastSui = new  ArmyRunable();
		ArmyRunable armyTastNongmin = new  ArmyRunable();
		// ʹ��runnable ��ڴ����߳�
		Thread armySui = new Thread(armyTastSui, "�峯");
		Thread armyNongmin = new Thread(armyTastNongmin, "ũ�������");
		
		armySui.start();
		armyNongmin.start();
		// ��̨�߳�����
		try {
			Thread.sleep(10);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("��·ɱ���˳�ҧ��");
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("��ҧ��");
		
		/**
		 * 	stop�����Ѿ������ˣ����Ǵ���ر�java �̵߳ķ���
			armySui.stop(); // �Գ������һ��ͻȻ��ֹͣ  ���Բ���
			armyNongmin.stop();
		 */
		
		/**
		 *  ��ȷ�ر�java�̵߳ķ��� �� ʹ���˳��ı�־
		 */
		armyTastSui.keepRuning = false;
		armyTastNongmin.keepRuning = false;
		
		
		try {
			Thread.sleep(10);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		mrCheng.start();
		
		
		try{
			//System.out.println("*************************");
			mrCheng.join();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ʹ�Ĵ�Ұ�����ҵ");
		System.out.println("_________________лл�ۿ�____________");
		
	}
	
	
	 /**
	  * 
	  */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Stage().start();
	}

}
