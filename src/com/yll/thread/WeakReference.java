package com.yll.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class WeakReference {
	
	public void getSwitch() {
		Integer i  = 23;
		
		switch (i) {
		case 23:  break; 

		default:
		}
		
	}
	
	public static void main(String[] args) {
		/*
		Map weakMap = new WeakHashMap<>();
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10000; i++) {
			Integer ii = new Integer(i);
			list.add(ii);
			weakMap.put(ii, new byte[i]);
		}*/
		
		int size = 1000;
		int[] array = new int[size];
		int[] arrayDest = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = i;
		}
		/*long startTime = System.currentTimeMillis();
		for(int k =0; k < 100000; k++) {
			System.arraycopy(array, 0, arrayDest, 0, size );
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime- startTime);*/
		
		arrayDest = Arrays.copyOf(array, size);
		for(int j = 0; j < size; j++) {
			System.out.println(arrayDest[j]);
		}
	}

}
