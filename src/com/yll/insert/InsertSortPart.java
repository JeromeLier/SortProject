package com.yll.insert;

/** 
 * @Description: http://blog.csdn.net/hguisu/article/details/7776068
 * @author LiliYue
 * @date 2015-4-30
 *  
 */
public class InsertSortPart {
	
	// 鐩存帴鎻掑叆鎺掑簭
	/**
	 * 
	 * @Description: 鐩存帴鎻掑叆鎺掑簭锛屼袱涓淮搴︼紝寰幆鍐呴儴in浠庡閮╫ut鑺傜偣寰�鍓嶄緷娆℃瘮杈�
	 * 鎻掑叆鎺掑簭绋冲畾
	 * @param arr
	 * @param n
	 * @return void
	 */
	public void insertSort(int[] arr, int n) {
		int in, out;
		for(out = 1; out< n; out++) {
			in = out;
			int temp = arr[in];
			while(in > 0 && temp < arr[in-1]) {
				arr[in] = arr[in-1];
				in--;
			}
			arr[in] = temp;
		}
	}
	
	
	/**
	 * 
	 * @Description: shellSort
	 * @param arr
	 * @param n
	 * @return void
	 */
	public void shellSort(int[] arr, int n) {
		
		
	}
	private void shellInsert(int[] arr, int n , int length) {
		
		
	}
	
	public void printArray(int[] arr) {
		int size = arr.length;
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
	
	public static void main(String[] args) {
		/*InsertSortPart sort = new InsertSortPart();
		long timeStart = System.currentTimeMillis();
		int[] arr = {49,38,65,97,76,13,27,49};
		sort.insertSort(arr, 8);
		sort.printArray(arr);
		long timeEnd = System.currentTimeMillis();
		System.out.println();
		System.out.print(timeEnd - timeStart +"ms");*/
		String a = "ad|cd|de";
		a = a.replaceAll("\\|", ",");
		System.out.println(a);
	}
	

}

