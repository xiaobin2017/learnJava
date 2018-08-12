package com.pagoda.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author dell1
 *
 *	Queue:是一个先进先出（FIFO）的数据结构
 *	Queue和set ,list 同一个级别都是继承collection接口 
 *  
 *	linkedList 实现Deque和 list 接口
 *
 * 没有实现阻塞的接口，实现了java.util.Queue和继承java.util.AbstractQueue接口
 * PriorityQueue
 * ConcurrentLinkedQueue
 * 实现阻塞的接口  实现 java.util.concurrent.BlockingQueue接口
 * ArrayBlockingQueue ：一个由数组组成的有边界队列
 * LinkedBlockingQueue：一个由链表组成的可选有边界队列
 * PriorityBlockingQueue:一个有优先级的无边界队列
 * DelayQueue：一个由优先级控制，基于时间的调度队列
 * SynchronousQueue ：一个利用 BlockingQueue 接口的简单聚集（rendezvous）机制。
 * 
 * JDK1.5后阻塞队列的操作
 * 
 * add  添加一个元素 如果是有边界队列，队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove 移除并返回队列头部的元素 ， 如果队列为空，则抛出一个NoSuchElementException异常
 * element 返回队列头元素，如果队列为空，则抛出一个NoSuchElementException异常
 * offer 添加一个元素，并且返回true 如果队列已经满了，则返回false
 * poll 移除并返回队列的头元素，如果队列为空，则返回null
 * peek 返回队列头元素，如果为空，则返回null
 * put 添加一个元素，如果队列已满，则阻塞
 * take 移除并返回队列头元素，如果队列为空，则阻塞
 * 
 * 除了 put take ，  add remove element offer poll peek 都是属于queue接口
 * 阻塞操作分3类，一类抛出异常：add element remove
 * 			 一类返回false或者null offer poll peek 
 * 			一类阻塞 put take 
 * 
 * LinkedBlockingQueue 是默认int长度的容量链表，可以指定长度
 * ArrayBlockingQueue 需要指定容量大小，并且可以选择是否公平，如果被设置true等待时间长的会优先执行，默认false
 * PriorityBlockingQueue 带有优先级比的队列，不是先进先出 ,默认长度11，当等于11的时候会扩容，做比较，10以
 * 						不会比较
 * 
 * 
 */
public class QueueStudy {
	public static void main(String[] args) {
//		PriorityBlockingQueue blockingQueue =new PriorityBlockingQueue();
//		
//		for (int i = 0; i < Integer.MAX_VALUE; i++) {
//			String string =i+"";
//			
//			blockingQueue.add(string);
//		}
//		
//		System.out.println(blockingQueue.toString());
		
		
		DelayQueue blockingQueue =new DelayQueue();
		
		for (int i = 0; i < 10; i++) {
			DelayedTest delayedTest=new DelayedTest(i+"");
			blockingQueue.add(delayedTest);
			
			
			System.out.println(delayedTest.getDelay(TimeUnit.SECONDS));
		}
		
		try {
			System.out.println("begin:"+System.currentTimeMillis());
			System.out.println(blockingQueue.take().toString());
			System.out.println("end:"+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(blockingQueue.toString());
		
	}
}


class DelayedTest implements Delayed {
	
	private String name ;
	
	/**
	 * @param name
	 */
	public DelayedTest(String name) {
		super();
		this.name = name;
	}

	public int compareTo(Delayed o) {
		return 0;
	}

	public long getDelay(TimeUnit unit) {
		
		return unit.toMillis(5000);
	}

	@Override
	public String toString() {
		return "DelayedTest [name=" + name + "]";
	}
	
}
