package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Redis {
	
	public static void main(String[] args){
		Redis redis = new Redis();
		redis.startRedis();
//		redis.stopRdedis();
	}
	
	public void startRedis(){
		try{
			ProcessBuilder builder = new ProcessBuilder ("cmd", "/c", "redis-server.exe redis.windows.conf"); 
			 builder.directory (new File ("D:/nginx+tomcat+redis/redis-windows-master/src/msopentech/redis-64.2.8.17")); 
			 Process process = builder.start (); 
			 InputStream is = process.getInputStream (); 
			 InputStreamReader isr = new InputStreamReader (is, "GBK"); 
			 BufferedReader br = new BufferedReader (isr); 
			 String line; 
			 while (( line = br.readLine () ) != null) 
			 {
				 System.out.println (line); 
			 }
			 System.out.println("start success~~~");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//直接关闭redis进程
	public void stopRdedis(){
		try {
			Runtime.getRuntime().exec("taskkill /F /IM redis-server.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}  

	}
	
	
}
