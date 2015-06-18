package com.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisManager {
	
	
	public static void main(String[] args){
		
		RedisManager rm = new RedisManager();
		Jedis jedis = rm.connectRedis();
		rm.redisString(jedis);
		rm.redisList(jedis);
		rm.redisKeys(jedis);
		
	}
	
	
	public Jedis connectRedis(){
		//���ӱ��ص� Redis ����
	      Jedis jedis = new Jedis("127.0.0.1");
	      System.out.println("Connection to server sucessfully");
	      //�鿴�����Ƿ�����
	      System.out.println("Server is running: "+jedis.ping());
	      return jedis;
	}
	
	
	public void redisString(Jedis jedis){
		//���� redis �ַ�������
	      jedis.set("w3ckey", "Redis tutorial");
	      jedis.setex("aaa", 1000, "1258");
	     // ��ȡ�洢�����ݲ����
	     System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
	}
	
	
	public void redisList(Jedis jedis){
		//�洢���ݵ��б���
	      jedis.lpush("tutorial-list", "Redis");
	      jedis.lpush("tutorial-list", "Mongodb");
	      jedis.lpush("tutorial-list", "Mysql");
	     // ��ȡ�洢�����ݲ����
	     List<String> list = jedis.lrange("tutorial-list", 0 ,5);
	     for(int i=0; i<list.size(); i++) {
	       System.out.println("Stored List in redis:: "+list.get(i));
	     }
	}
	
	public void redisKeys(Jedis jedis){
		// ��ȡ���ݲ����
	     Set<String> set = jedis.keys("*");
	     Iterator it = set.iterator();
	     while(it.hasNext()){
	    	 Object obj = it.next();
	    	 System.out.println("key of stored keys:: "+obj);
	     }
	}
	
}
