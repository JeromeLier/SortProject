package com.yll.sort;

import java.util.ArrayList;
import java.util.List;

public class OtherSort {

	 private static int NUM = 4;  
	  
    /** 
     * 递归算法：将数据分为两部分，递归将数据从左侧移右侧实现全排列 
     * 
     * @param datas 
     * 生成了两个数据空间
     * @param target 
     */  
    private static void sort(List<String> datas, List<String> target) {
        if (target.size() == NUM) {  
            for (Object obj : target)  
                System.out.print(obj + ", ");  
            System.out.println();  
            return;  
        } 
        for (int i = 0; i < datas.size(); i++) {  
            List<String> newDatas = new ArrayList<String>(datas);  
            List<String> newTarget = new ArrayList<String>(target);  
            if(! newTarget.contains(newDatas.get(i))) {
            	newTarget.add(newDatas.get(i));  
            	newDatas.remove(i);
            	sort(newDatas, newTarget);              	
            }
        }  
    }  

	public static void main(String[] args) {
		List<String> arrayList = new ArrayList<String> ();
		arrayList.add("1");
		arrayList.add("2");
		arrayList.add("2");
		arrayList.add("2");
		/*for (int i = 0; i< arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		sort(arrayList, new ArrayList());*/
		
		for(String str : arrayList) {
			arrayList.remove(str);
		}
	}

}
