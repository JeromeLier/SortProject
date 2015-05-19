package com.yll.thread;

public class KeyPersonThread extends Thread {

	public void run() {
		System.out.println(Thread.currentThread().getName() +"开始了战斗");
		for (int i = 0; i< 5; i++) {
			System.out.println(Thread.currentThread().getName() +" 击杀随军  [" + i + "]");
			// 机器让出了处理器时间
			Thread.yield();
		}
		System.out.println(Thread.currentThread().getName() +"结束了战斗");
		
	}
	
}
