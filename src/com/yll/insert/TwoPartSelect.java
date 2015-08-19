package com.yll.insert;

public class TwoPartSelect {

	public int getMinNum(int[] arr, int left,  int right) {
		if(left < right - 1) {
			int middle = (left + right)/2;
			if(arr[middle] > arr[left]) {
				// 说明在这个middle的右边 继续查找
				return getMinNum(arr,  middle,  right);
			}else{
				return getMinNum(arr,  left,  middle);
			}
		}
		if(arr[left] < arr[right]) 
			return arr[left];
		
		return arr[right];
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] arr ={3,4,5,1,2};
		TwoPartSelect t = new TwoPartSelect();
		System.out.println(t.getMinNum(arr, 0,4));

	}

}
