package com.yll.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** 
 * @Description: 
 * @author LiliYue
 * @date 2015-5-5
 *  
 */
public class ArrayAndLinkedListCost {

	
	public static void main(String[] args) {
		//ArrayList娣诲姞鍏冪礌鐨勬晥鐜�
		ArrayList<String> arrList = new ArrayList<String>();
        long startTimeMillis, endTimeMillis;
        startTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrList.add(0, "addString");
        }
        endTimeMillis = System.currentTimeMillis();
        System.out.println("ArrayList:" + (endTimeMillis - startTimeMillis)+ "ms");

        arrList.clear();

        startTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            arrList.add(0, "addString");
        }
        endTimeMillis = System.currentTimeMillis();
        System.out.println("ArrayList:" + (endTimeMillis - startTimeMillis) + "ms");

        arrList.clear();

        startTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 40000; i++) {
            arrList.add(0, "addString");
        }
        endTimeMillis = System.currentTimeMillis();
        System.out.println("ArrayList:" + (endTimeMillis - startTimeMillis) + "ms");

        arrList.clear();

        startTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {
            arrList.add(0, "addString");
        }
        endTimeMillis = System.currentTimeMillis();
        System.out.println("ArrayList:" + (endTimeMillis - startTimeMillis) + "ms");

        arrList.clear();

        startTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 160000; i++) {
            arrList.add(0, "addString");
        }
        endTimeMillis = System.currentTimeMillis();
        System.out.println("ArrayList:" + (endTimeMillis - startTimeMillis) + "ms");

        arrList.clear();
        
        startTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 320000; i++) {
            arrList.add(0, "addString");
        }
        endTimeMillis = System.currentTimeMillis();
        System.out.println("ArrayList:" + (endTimeMillis - startTimeMillis) + "ms");
        
        Map<String,String> maps = new HashMap<String, String>();
        
	}
}
