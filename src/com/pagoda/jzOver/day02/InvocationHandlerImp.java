package com.pagoda.jzOver.day02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImp implements InvocationHandler {
	private Object jdkProxyImp;

	public InvocationHandlerImp(Object jdkProxyImp) {
		this.jdkProxyImp = jdkProxyImp;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用前");
		System.out.println("method：" + method);

		Object object = method.invoke(jdkProxyImp, args);

		return object;
	}

}
