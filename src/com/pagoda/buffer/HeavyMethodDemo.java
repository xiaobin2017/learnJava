package com.pagoda.buffer;

import net.sf.cglib.proxy.Enhancer;

public class HeavyMethodDemo {
	public String  heavyMethodDemo(int num){
		StringBuffer sb=new StringBuffer();
		sb.append(num);
		return sb.toString();
	} 
	
	public static  HeavyMethodDemo  newCacheHeavyMethod(	){
	Enhancer enhancer=new Enhancer(); 
	enhancer.setSuperclass(HeavyMethodDemo.class);
	enhancer.setCallback(new CglibHeavyMethodInteceptor());
	
	HeavyMethodDemo methodDemo=(HeavyMethodDemo) enhancer.create();
	return methodDemo;
	
	} 
	
	
	public static void main(String[] args) {
		HeavyMethodDemo heavyMethodDemo=newCacheHeavyMethod();
		System.out.println(heavyMethodDemo.heavyMethodDemo(1));
		
	}
	
}

