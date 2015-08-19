package com.yll.design.decorator;

/**
 * 装饰器模式
 * @author Yuelili
 *定义了一个接口基本类
 *
 */
public class ConcreteComponent  implements Component{
	
	@Override
	public void method() {
		System.out.println("最原始的方法");
	}
}
