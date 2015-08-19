package com.yll.sort;

import java.util.ArrayList;
import java.util.List;

public class PermSort {

	
	
	public static void print(List<String> list, int length) {
		for(int i = 0; i< length; i++) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.println();
	}
	/**
	 * 
	 * @param sourceList
	 * @param targetList
	 */
	public static void permSort( List<String> sourceList, List<String> targetList) {
		if (targetList.size() == 4) {
			print(targetList, 4);	
			return;
		}
		for(int i = 0; i < sourceList.size(); i++) {
			List<String> newList = new ArrayList<String>(sourceList);
			List<String> newTargetList = new ArrayList<String>(targetList);
			newTargetList.add(newList.get(i));
			newList.remove(i);
			permSort(newList, newTargetList);
			
		}
			
	}
	
	
	public static void main(String[] args) {
		
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("1");
		arrayList.add("2");
		arrayList.add("2");
		arrayList.add("4");
		permSort(arrayList, new ArrayList<String>());
	}

}
