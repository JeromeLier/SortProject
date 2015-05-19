package com.yll.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

/** 
 * @Description: 
 * @author LiliYue
 * @date 2015-5-5
 *  
 */
public class SetCollection {

	/**
	 * @Description: main
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		//Set基础操作
        List<Integer> list = new ArrayList<Integer>();
        System.out.println("list serial:" + list.hashCode());
        list.add(3);
        //System.out.println("list serial:" + list.hashCode());
        list.add(4);
        //System.out.println("list serial:" + list.hashCode());
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(6);
        // 重复元素将不能被添加
        hashSet.add(3);
        // 只要有元素被添加就返回true
        if (hashSet.addAll(list)) {
            System.out.println("Add success");
            //SSystem.out.println("list serial:" + list.hashCode());
        }
        // 判断是否存在某个集合
        if (hashSet.containsAll(list)) {
            System.out.println("The hashSet is contain 3 and 4");
        }
        Iterator<Integer> it = hashSet.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
            // 1 2 3 4 6
            // 看结果是被排序了，HashSet按照Hash函数排序，Integer值的HashCode就是其int值
        }
        // 换转成数组
        Object[] integers = hashSet.toArray();
        for (int i = 0; i < integers.length; i++) {
            System.out.print((Integer) integers[i]);
        }
        //移除元素
        hashSet.remove(3);
        
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("D");
        treeSet.add("B");
        for (Iterator<String> strIt = treeSet.iterator(); strIt.hasNext();) {
            System.out.print(strIt.next());
            // ABCD 按照字母顺序
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("C");
        linkedHashSet.add("A");
        linkedHashSet.add("D");
        linkedHashSet.add("B");
        for (Iterator<String> linkedIt = linkedHashSet.iterator(); linkedIt
                .hasNext();) {
            System.out.print(linkedIt.next());
            // CADB 按照插入顺序
        }

	}

}
