package com.yll.thread;


public class Stage extends Thread {

	
	public void run() {
		System.out.println("_________________开始观看隋唐演义____________");
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("_________________斗争开始 随军和农民起义军开始扣证____________");
		
		ArmyRunable armyTastSui = new  ArmyRunable();
		ArmyRunable armyTastNongmin = new  ArmyRunable();
		// 使用runnable 借口创建线程
		Thread armySui = new Thread(armyTastSui, "隋朝");
		Thread armyNongmin = new Thread(armyTastNongmin, "农民起义军");
		
		armySui.start();
		armyNongmin.start();
		// 舞台线程休眠
		try {
			Thread.sleep(10);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("半路杀出了程咬金");
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");
		
		/**
		 * 	stop方法已经不用了，这是错误关闭java 线程的方法
			armySui.stop(); // 对程序产生一个突然地停止  所以不好
			armyNongmin.stop();
		 */
		
		/**
		 *  正确关闭java线程的方法 ： 使用退出的标志
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
		System.out.println("使的大家安居乐业");
		System.out.println("_________________谢谢观看____________");
		
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
