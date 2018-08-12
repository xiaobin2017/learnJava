package com.pagoda.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定义一个菜篮子
 * 
 * @author dell1
 *
 */
public class Basket {
	// 菜篮可以装3个苹果
	BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);

	// 生产苹果，放入菜篮
	public void produce() throws InterruptedException {
		basket.put("An apple");
	}

	// 消费苹果
	public String consume() throws InterruptedException {
		String apple = basket.take();
		return apple;
	}

	public int getAppleNumber() {
		return basket.size();
	}

	public static void testBasket() {
		// 新建一个装苹果的篮子
		final Basket basket = new Basket();
		
		//创建苹果的生产者
		class Producer implements Runnable {

			public void run() {
				while(true){
					//生产苹果
					try {
						System.out.println("Producer begin ："+System.currentTimeMillis());
						basket.produce();
						System.out.println("Producer end ："+System.currentTimeMillis());
						
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
			
			
		};
		//创建苹果的消费者
		class Consumer implements Runnable {

			public void run() {
				while(true){
					//生产苹果
					try {
						System.out.println("Consumer begin ："+System.currentTimeMillis());
						basket.consume();
						System.out.println("Consumer end ："+System.currentTimeMillis());
						System.out.println("apple size:"+basket.getAppleNumber());
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
			
			
		};
		
		ExecutorService executorService =Executors.newCachedThreadPool();
		Producer producer=new Producer();
		Consumer consumer=new Consumer();
		executorService.submit(producer);
		executorService.submit(consumer);
		  // 程序运行10s后，所有任务停止
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		executorService.shutdownNow();
		
		
		}
		
	public static void main(String[] args) {
		Basket.testBasket();
	}

	}
