package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Nginx {
	
	public static void main(String[] args){
		Nginx nginx = new Nginx();
		nginx.startNginx();
	}
	
	public void startNginx(){
		try{
			ProcessBuilder builder = new ProcessBuilder ("cmd", "/c", "start nginx"); 
			 builder.directory (new File ("D:\nginx+tomcat+redis\nginx-1.9.1")); 
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
	
	
	public void stopNginx(){
		try{
			ProcessBuilder builder = new ProcessBuilder ("cmd", "/c", "nginx -s quit"); 
			 builder.directory (new File ("D:\nginx+tomcat+redis\nginx-1.9.1")); 
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
	
}
