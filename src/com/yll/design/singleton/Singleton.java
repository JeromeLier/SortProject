package com.yll.design.singleton;

/**
 *  懒汉模式： 线程不安全
 * @author Yueli
 */
public class Singleton {

	private static Singleton singleton;
	public Singleton(){}
	
	public static Singleton getInstance(){
		
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

}
/**
 * 懒汉模式 : 线程安全
 * @author Yueli
 */
class SysSingleton {
	private static SysSingleton singleton;
	public SysSingleton(){}
	
	/**
	 * 直接锁住这个方法。所有访问这个方法都要排队
	 * 类似于 public static  Singleton getInstance(){synchronized(Singleton.class){****}}
	 */
	public static synchronized SysSingleton getInstance1(){
		if(singleton == null) {
				singleton = new SysSingleton();	
		}
		return singleton;
	}
	
	/**
	 * 只锁住部分的代码段。这样的效率会更高一些
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
 * 饿汉模式 ：线程非安全 和非线程安全参照上面懒汉模式
 *
 */
class HungSingleton {
	// 唯一的区别就在这里。。。这里初始化了一次
	private static HungSingleton singleton = new HungSingleton();
	public  HungSingleton (){}
	public static HungSingleton getInstance(){
		if(singleton == null) {
			singleton = new HungSingleton();
		}
		return singleton;
	}
}
