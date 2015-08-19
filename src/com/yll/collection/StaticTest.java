package com.yll.collection;

public class StaticTest {
	
	private static int a ;
	static void outPrint() {
		a++;
		System.out.println("a: " + a );
	}
	
	static {
		System.out.println(a);
		a+=2;
		System.out.println("a_ : " + a);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main : " + a);
		
		StaticTest.outPrint();

	}

}
