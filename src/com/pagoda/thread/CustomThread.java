package com.pagoda.thread;

public class CustomThread extends Thread {
@Override
public void run() {
	Thread.currentThread().yield();
	try {
		Thread.sleep(600000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Running.....:"+Thread.currentThread().getName());
}
}
