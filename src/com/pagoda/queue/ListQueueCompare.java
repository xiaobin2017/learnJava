package com.pagoda.queue;

import java.util.concurrent.LinkedBlockingQueue;



/**
 * 
 * @author dell1
 * LinkedList,ConcurrentLinkedQueue,LinkedBlockingQueue 
 * 
 * LinkedList :追加，多并发下，size大于实际值
 * ConcurrentLinkedQueue 并发下以cas算法实现原子操作
 * LinkedBlockingQueue 以锁的机制实现高并发，锁实现是以CAS算法
 * 优先选择ConcurrentLinkedQueue
 * 
 */
public class ListQueueCompare {
	public static void main(String[] args) {
		final LinkedBlockingQueue linkedList =new LinkedBlockingQueue();
		
		for ( int f = 0; f < 100; f++) {
			
			new Thread(new Runnable() {
				
				public void run() {
					for (int j = 0; j < 1000; j++) {
						linkedList.add(Thread.currentThread().getName()+":"+j);
					}
					
				}
			}).start();
			
		}
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num=linkedList.size();
		
		System.out.println(num);
		
//		System.out.println(linkedList.get(2030));
	
	}
}
