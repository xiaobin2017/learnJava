package com.pagoda.thread;

public class JavaThreadCreatAndRun {

	public static void main(String[] args) {
		System.out.println("main method was excute by thread " + Thread.currentThread().getName());
//		Helper helper = new Helper("java thread AnyWhere");
//		helper.run();
		
//		Thread thread = new Thread(helper);
//		thread.setName("A-Work thread");
//		thread.start();
		
		Thread thread=new CustomThread();
		thread.setName("A-Work thread");
		thread.start();
		
//		try {
//			thread.currentThread().sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(thread.getState());
	}
}
