package com.yll.design.singleton;

/**
 *  ����ģʽ�� �̲߳���ȫ
 * @author Yueli
 */
public class Singleton {

	private static Singleton singleton;
	private Singleton(){}
	
	public static Singleton getInstance(){
		
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

}
/**
 * ����ģʽ : �̰߳�ȫ
 * @author Yueli
 */
class SysSingleton {
	private static SysSingleton singleton;
	public SysSingleton(){}
	
	/**
	 * ֱ����ס������������з������������Ҫ�Ŷ�
	 * ������ public static  Singleton getInstance(){synchronized(Singleton.class){****}}
	 */
	public static synchronized SysSingleton getInstance1(){
		if(singleton == null) {
				singleton = new SysSingleton();	
		}
		return singleton;
	}
	
	/**
	 * ֻ��ס���ֵĴ���Ρ�������Ч�ʻ����һЩ
	 * @return
	 */
	public static SysSingleton getInstance(){
		if(singleton == null) {
			synchronized (SysSingleton.class) {
				if(singleton == null) {
					singleton = new SysSingleton();
				}
			}
		}
		return singleton;
	}
}
/**
 * ����ģʽ ���̷߳ǰ�ȫ �ͷ��̰߳�ȫ������������ģʽ
 *
 */
class HungSingleton {
	// Ψһ���������������������ʼ����һ��
	private static HungSingleton singleton = new HungSingleton();
	public  HungSingleton (){}
	public static HungSingleton getInstance(){
		if(singleton == null) {
			singleton = new HungSingleton();
		}
		return singleton;
	}
}
