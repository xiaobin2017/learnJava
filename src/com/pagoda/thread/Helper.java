package com.pagoda.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Helper implements Runnable{
	String name;
	public Helper(String name) {
		this.name=name;
	}
	public void run() {
		dosomething(name);
		
	}
	private void dosomething(String name2) {
		System.out.println("the do something was excute by thread " + Thread.currentThread().getName());
		System.out.println("do some thing with "+name);
	}

	
	public static void main(String[] args) {
		Map<String, Object> hashMap =Collections.synchronizedMap(new HashMap<String, Object>());
	
	}
}
