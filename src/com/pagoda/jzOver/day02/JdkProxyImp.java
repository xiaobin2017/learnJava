package com.pagoda.jzOver.day02;

public class JdkProxyImp implements JdkProxy {

	public String Sayhello(String hello) {

		System.out.println("ni hao:" + hello);
		return hello;
	}

	public String SayGoodBye(String goodBye) {
		System.out.println("byebye:" + goodBye);

		return goodBye;
	}
	

}
