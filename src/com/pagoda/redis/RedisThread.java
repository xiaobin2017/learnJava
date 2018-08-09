package com.pagoda.redis;

import java.util.Date;

import redis.clients.jedis.Jedis;

public class RedisThread extends Thread{
	int i=0;
	
	public RedisThread(int i ) {
		i=i;
	}
	@Override
	public void run() {
		Jedis jedis=new Jedis("119.29.183.114",6003);
		jedis.auth("redis@123");
		
		for(int j=100000;j<200000;j++){
			jedis.sadd("memberId", "Thread.currentThread().getName()"+i+j);	
		}
		
		System.out.println(Thread.currentThread().getName()+"结束时间："+new Date());
	}
}
