package com.pagoda.thread;


public class TreadTest {
	public static void main(String[] args) {
		test(1);

		
	}
	
	
	public static void test(final int id){
		new Thread(){
			public void run() {
				
				System.out.println("进入线程");
				try {
					Thread.sleep(6000);
					
					if(id==2){
						System.out.println("进入退出线程");
						return;
					}
				} catch (InterruptedException e) {
				}
				System.out.println(id);
				System.out.println("线程执行完");
			};
		}.start();
		
		System.out.println("test:"+id);
	}
}
