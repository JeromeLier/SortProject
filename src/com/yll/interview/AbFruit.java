package com.yll.interview;

public abstract  class AbFruit implements IFruit {
	private int weight = 6;
	public abstract void getWeight();
	
	
	public static void main(String[] args) {
		
		AbFruit fruit = new AbFruit() {
			
			@Override
			public void getWeight() {
				// TODO Auto-generated method stub
			}
		};
		fruit.getWeight();
	}

}
