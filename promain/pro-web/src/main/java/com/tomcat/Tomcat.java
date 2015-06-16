package com.tomcat;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tomcat {
	public void  CmdExec(String cmdline) { 
		try { 
			String line; 
			Process p = Runtime.getRuntime().exec(cmdline); 
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream())); 
			while ((line = input.readLine()) != null) { 
				System.out.println(line); 
			} 
			input.close(); 
		} catch (Exception err) { 
			err.printStackTrace(); 
		}
	} 

		public static void main(String argv[]) {
			Tomcat tom = new Tomcat();
//			cmd.exe /c D:\\apache-tomcat-6.0.18\\bin\\startup.bat
//			tom.CmdExec("cmd.exe /c D:\\nginx+tomcat+redis\\nginx-tomcatv7-18062\\bin\\startup.bat");
//			tom.CmdExec("cmd.exe /k start D:\\nginx+tomcat+redis\\nginx-tomcatv7-18062\\bin\\startup.bat");
//			tom.CmdExec("cmd.exe /c start D:/nginx+tomcat+redis/nginx-tomcatv7-18062/bin/startup.bat");
//			tom.CmdExec("cmd.exe /c dir");
			System.out.println("end start");
			
			tom.testbat();
			
		} 
		
		
		public void testbat (){
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
