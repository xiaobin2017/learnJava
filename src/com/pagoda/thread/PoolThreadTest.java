package com.pagoda.thread;


public class PoolThreadTest {
	public static  Object obj=new Object();
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(PoolThreadTest.obj.toString());
			
		}
		
	}
}
