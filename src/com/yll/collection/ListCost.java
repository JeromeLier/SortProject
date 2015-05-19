package com.yll.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** 
 * @Description: 
 * @author LiliYue
 * @date 2015-5-5
 *  
 */
public class ListCost {

	public static void main(String[] args) {
		
		ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Tom");
        arrayList.add("Jerry");
        arrayList.add("Micky");
        // 浣跨敤Iterator閬嶅巻鍏冪礌
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }
        // 鍦ㄦ寚瀹氫綅缃彃鍏ュ厓绱�
        arrayList.add(2, "Kate");
        // 閫氳繃绱㈠紩鐩存帴璁块棶鍏冪礌
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        List<String> subList = new ArrayList<String>();
        subList.add("Mike");
        arrayList.addAll(subList);
        // 鍒ゆ柇鏄惁鍖呭惈鏌愪釜鍏冪礌
        if (arrayList.contains("Mike")) {	
            System.out.println("Mike is include in the list");
        }

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.addAll(arrayList);
        // 鑾峰彇鎸囧畾鍏冪礌
        System.out.println(linkedList.get(4));
        // 鑾峰彇绗竴涓厓绱�
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.peekFirst());
	}
	

}
