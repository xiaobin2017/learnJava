package com.pagoda.file;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class checkQueue extends Thread{
	
	static ReferenceQueue<ReferentTest> softQuery =null;
	
	public void run() {
		Reference<ReferentTest> reference=null;
		try {
			reference=(Reference<ReferentTest>) softQuery.remove();
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		ReferentTest referentTest = new ReferentTest();
		// 创建引用队列
		softQuery = new ReferenceQueue<ReferentTest>();
		// 创建软引用
		SoftReference softReference = new SoftReference<ReferentTest>(referentTest, softQuery);
		new checkQueue().start();
		referentTest=null;
		
		
		System.gc();
		
		System.out.println("After GC :soft get="+softReference.get());
		
		
		System.out.println("分配最大内存");
		byte[] b=new byte[4*1024*925];
		
		System.out.println("After new byte :soft get="+softReference.get());
		
	
		
	}
	
}
