package com.pagoda.jzOver.day02;

public class DynamicProxyDemonstration {

	JdkProxyImp jdkProxyImp = new JdkProxyImp();
	InvocationHandlerImp handlerImp = new InvocationHandlerImp(jdkProxyImp);
	
	

}
