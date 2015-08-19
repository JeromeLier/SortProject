package com.xiaohong.optimize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RopeParam {

	@SuppressWarnings("unused")
	private static final Integer LimitUse  = 0;
	private Map<Double, Integer> ropeNumberMap = new HashMap<Double, Integer>();
	private List<Double> strandLegthList = new ArrayList<Double>();

	// 横轴
	private List<Double> selectSList = new ArrayList<Double>();
	private List<Double> constSelectList = new ArrayList<Double>();
	//纵轴求和
	private List<Integer> countSList = new ArrayList<Integer>();
	private List<Integer> constCountSList = new ArrayList<Integer>();
	
	public Map<Double, Integer> getRopeNumberMap() {
		return ropeNumberMap;
	}



	public void setRopeNumberMap(Map<Double, Integer> ropeNumberMap) {
		this.ropeNumberMap = ropeNumberMap;
	}



	public List<Double> getStrandLegthList() {
		return strandLegthList;
	}



	public void setStrandLegthList(List<Double> strandLegthList) {
		this.strandLegthList = strandLegthList;
	}
	
	public RopeParam(Map<Double, Integer> ropeNumberMap, List<Double> arrayList ) {
		this.ropeNumberMap = ropeNumberMap;
		this.strandLegthList = arrayList;
	}
	
	/**
	 * 获取所有的集合数目
	 * @param countSList
	 * @param outList
	 *//*
	public void  recursive(List<Integer> countSList, List<Integer> outList) {
		if(outList.size() == 6) {
			for(int i = 0 ; i < outList.size(); i++) {
				System.out.print(outList.get(i) + " ");
			}
			System.out.println();
			return ;
		}
		if(countSList.size() <= 0) {
			return;
		}
		for(int j = 0; j <= countSList.get(0); j++) {
			List<Integer> newList = new ArrayList<Integer>(countSList);
			List<Integer> newTargetList = new ArrayList<Integer>(outList);
			newTargetList.add(j);
			newList.remove(0);
			recursive(newList, newTargetList);
		}
		
	}
	*/

	/**
	 * 
	 * @param countSList
	 * @param outList
	 * @param ropeLength
	 * @param selectSList 每一个的权重
	 */
	/*public void  recursiveCount(List<Integer> countSList, List<Integer> outList, double length, List<Double> selectSList) {
		if(outList.size() == 6) {
			if(length >= 2) {
				//排除最优解，剩余材料太多。。
				return ;
			}
			for(int i = 0 ; i < outList.size(); i++) {
				// 输出当
				System.out.print(outList.get(i) + " ");
			}
			System.out.println();
			return ;
		}
		if(countSList.size() <= 0) {
			return;
		}
		for(int j = 0; j <= countSList.get(0); j++) {
			
			Double newRopeLength = length - selectSList.get(0) * j;
			if(newRopeLength < 0) {
				break;
			}
			List<Integer> newList = new ArrayList<Integer>(countSList);
			List<Integer> newTargetList = new ArrayList<Integer>(outList);
			List<Double> newSelectSList = new ArrayList<Double>(selectSList);
			newTargetList.add(j);
			newList.remove(0);
			newSelectSList.remove(0);
			//ropeLengthList.set(0, newRopeLength);
			recursiveCount(newList, newTargetList,newRopeLength, newSelectSList);
		}
		
	}
	
	*/
	
	
	public void  recursiveCount(List<Integer> countSList, List<Integer> constCountSList, List<Integer> outList, List<Double> ropeLengthList, List<Double> selectSList, List<Double>finalSelectList) {
		if(outList.size() == 6) {
			/*if(ropeLengthList.get(0) >= 2) {
				//排除最优解，剩余材料太多。。6
				return ;
			}*/
			for(int i = 0 ; i < outList.size(); i++) {
				// 输出一个解决方案  3006 下的 
				System.out.print(outList.get(i) + " ");
			}
			System.out.println();
			List<Double> newRopeList = new ArrayList<Double>(ropeLengthList);
			newRopeList.remove(0);
			if(newRopeList.size() == 0) {
				System.out.println("结束了");
				return;
			}
			recursiveCount(constCountSList, constCountSList, new ArrayList<Integer>(), newRopeList, finalSelectList, finalSelectList);
			
			System.out.println();
			return ;
		}
		if(countSList.size() <= 0) {
			return;
		}
		for(int j = 0; j <= countSList.get(0); j++) {
			
			Double newRopeLength = ropeLengthList.get(0) - selectSList.get(0) * j;
			if(newRopeLength < 0) {
				break;
			}
			List<Integer> newList = new ArrayList<Integer>(countSList);
			List<Integer> newTargetList = new ArrayList<Integer>(outList);
			List<Double> newSelectSList = new ArrayList<Double>(selectSList);
			newTargetList.add(j);
			newList.remove(0);
			newSelectSList.remove(0);
			ropeLengthList.set(0, newRopeLength);
			recursiveCount(newList, constCountSList, newTargetList,ropeLengthList, newSelectSList,finalSelectList);
		}
		
	}
	
	
	/**
	 * 
	 * @param ropeNumberMap  存储 键值对   key108.32， count 122 集合
	 * @param strandLegthList 3006 3014  3015 3015 2887 2864 2857  2846  2840 2834 2830 2780 这样的集合
	 * @param selectSList  
	 * @param countSList
	 * @param istail
	 */
	
	
	
	public RopeParam() {
		/*ropeNumberMap.put(108.32, 122);
		ropeNumberMap.put(113.67, 122);
		ropeNumberMap.put(119.44, 122);
		ropeNumberMap.put(125.27, 122);
		ropeNumberMap.put(131.32, 122);
		ropeNumberMap.put(137.55, 122);
		ropeNumberMap.put(106.53, 122);
		strandLegthList.add(3006.00);
		strandLegthList.add(3014.00);
		strandLegthList.add(3015.00);*/
		/*selectSList.add(108.32);
		selectSList.add(113.67);
		selectSList.add(119.44);
		selectSList.add(131.32);
		selectSList.add(137.55);
		selectSList.add(106.53);*/
		
		selectSList.add(3.00);
		selectSList.add(3.00);
		selectSList.add(3.00);
		selectSList.add(3.00);
		selectSList.add(3.00);
		selectSList.add(3.00);
		constSelectList = new ArrayList<Double>(selectSList);
		
		
		countSList.add(1);
		countSList.add(2);
		countSList.add(3);
		countSList.add(3);
		countSList.add(2);
		countSList.add(1);
		constCountSList = new ArrayList<Integer>(countSList);
		
		// 3005 3306 
		List<Double> ropeList = new ArrayList<Double>();
		ropeList.add(10.0);
		ropeList.add(12.0);
		ropeList.add(12.0);
		ropeList.add(8.0);
		recursiveCount(countSList, constCountSList, new ArrayList<Integer>(), ropeList, selectSList, constSelectList);
		
	}
	
	public static void main(String[] args) {
		
		RopeParam rope = new RopeParam();
	}


}
