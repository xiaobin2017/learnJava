package com.pagoda.redis;

import redis.clients.jedis.Jedis;

public class RedisJava {
	public static void main(String[] args) {
		Jedis jedis=new Jedis("119.29.183.114",6003);
		jedis.auth("redis@123");
//		System.out.println(jedis.ping());
		
	    System.out.println("清空库中所有数据："+jedis.flushDB());
	    
		for(int i=0;i<500000;i++){
			jedis.sadd("memberId", "test"+i);	
		}
		System.out.println(jedis.smembers("memberId").size());	
		
	}
}
