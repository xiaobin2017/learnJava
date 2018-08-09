package com.pagoda.redis;

import java.util.Date;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisShare {

	private static JedisPool jedisPool;// 非切片连接池

	private static void initialPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(60 * 60 * 1000);
		config.setTestOnBorrow(false);
		jedisPool = new JedisPool(config, "119.29.183.114", 6003);
	}

	public static void main(String[] args) {
		Jedis jedis=new Jedis("119.29.183.114",6003);
		jedis.auth("redis@123");
		
		System.out.println("清空库中所有数据：" + jedis.flushDB());
		
		System.out.println("开始时间："+new Date());
		for (int i = 0; i < 15; i++) {
			new RedisThread(i).start();
			
			System.out.println("开启线程："+i);
		}
	
		// initialPool();
		//
		// Jedis jedis=jedisPool.getResource();
		// jedis.auth("redis@123");
		// System.out.println("清空库中所有数据："+jedis.flushDB());
		//
		// for (int i = 0; i < 15; i++) {
		// new Thread(new Runnable() {
		// public void run() {
		// Jedis jedis1=jedisPool.getResource();
		// jedis1.auth("redis@123");
		// for(int j=0;j<100000;j++){
		// jedis1.sadd("memberId", "test"+j);
		// }
		// }
		// }).start();
		// }
		//
	}
}
