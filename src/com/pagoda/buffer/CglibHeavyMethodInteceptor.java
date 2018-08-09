package com.pagoda.buffer;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibHeavyMethodInteceptor implements MethodInterceptor {
	HeavyMethodDemo heavyMethodDemo=new HeavyMethodDemo();
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		//查询缓存
		System.out.println("查询缓存");
		
		//放入数据
		String str=heavyMethodDemo.heavyMethodDemo(2);
		return str;
	}

}
