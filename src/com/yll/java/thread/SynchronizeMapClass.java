package com.yll.java.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 保证数据插入的连续性 serial access 不过
 * 后期基本使用concurrentHashmap方法了
 * @author Yuelili
 *
 */
public class SynchronizeMapClass {
	
	// 插入后便不可更改
	public static Map<String, String> lastLoginMap = Collections.synchronizedMap(new HashMap<String, String>());
	
	public static void main(String[] args) {
		
		String date1  = "123";
		String date2 = "345";
		
		SynchronizeMapClass.lastLoginMap.put("john", date1);
		SynchronizeMapClass.lastLoginMap.put("kemi", date2);
		
		for(String key : SynchronizeMapClass.lastLoginMap.keySet()) {
			System.out.println("user: " + key + " time: " + SynchronizeMapClass.lastLoginMap.get(key));
		}

		SynchronizeMapClass.lastLoginMap.put("kemi", date1);
		
		
		for(String key : SynchronizeMapClass.lastLoginMap.keySet()) {
			System.out.println("user: " + key + " time: " + SynchronizeMapClass.lastLoginMap.get(key));
		}
		
	}

}
