package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tomcat {
		public static void main(String argv[]) {
			Tomcat tom = new Tomcat();
			tom.startBatByProcess();
//			tom.stopBatByprocess();
		} 
		
		public void stopBatByprocess (){
			try{
				ProcessBuilder builder = new ProcessBuilder ("cmd", "/c", "shutdown.bat"); 
				 builder.directory (new File ("D:/nginx+tomcat+redis/nginx-tomcatv7-18062/bin/")); 
				 Process process = builder.start (); 
				 InputStream is = process.getInputStream (); 
				 InputStreamReader isr = new InputStreamReader (is, "GBK"); 
				 BufferedReader br = new BufferedReader (isr); 
				 String line; 
//				 process.destroy();
				 while (( line = br.readLine () ) != null) 
				 {
					 System.out.println (line); 
				 }
//				 process.destroy();
				 
				 System.out.println("stop success~~~");
			}catch(Exception e){
				e.printStackTrace();
			}
			 
		 } 
		
		
		public void startBatByProcess (){
			try{
				ProcessBuilder builder = new ProcessBuilder ("cmd", "/c", "startup.bat"); 
				 builder.directory (new File ("D:/nginx+tomcat+redis/nginx-tomcatv7-18062/bin/")); 
				 Process process = builder.start (); 
				 InputStream is = process.getInputStream (); 
				 InputStreamReader isr = new InputStreamReader (is, "GBK"); 
				 BufferedReader br = new BufferedReader (isr); 
				 String line; 
//				 process.destroy();
				 while (( line = br.readLine () ) != null) 
				 {
					 System.out.println (line); 
				 }
//				 process.destroy();
				 
				 System.out.println("start success~~~");
			}catch(Exception e){
				e.printStackTrace();
			}
			 
		 } 

		
		
		

}
