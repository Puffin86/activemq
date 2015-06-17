package com.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL; 
import java.net.URLConnection; 
 
import java.util.Date; 

public class MonitorTomcat {
	    private void keepTomcatAlive() throws NullPointerException { 
	       
	       String t = new String("mytomcat.exe"); 
	       boolean isTomcatAlive = false; 
	       java.io.BufferedReader in; 
	       String s; 
	       try { 
	           URL url = new URL("http://localhost:18062/simpleweb/"); 
	           URLConnection con = url.openConnection(); 
	           in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
	           con.setConnectTimeout(5000); 
	           con.setReadTimeout(10000); 
	           while ((s = in.readLine()) != null) {
	        	   System.out.println(s);
	              if (s.length() > 0) {
	                  // 如果能够读取到页面则证明tomcat正常，直接return
	                  return; 
	              } 
	           } 
	           in.close(); 
	       } catch (Exception ex) { 
	    	   ex.printStackTrace();
	       } 
	 
	       //判断进程中是否含有该tomcat进程
	       //由于绿色版本的tomcat进程统一名称是jave.exe,可以通过修改进程名来识别，修改方法参考
//	    1、window平台：
//	     　　打开tomcat_home\bin\setclasspath.bat文件，找到set _RUNJAVA="%JRE_HOME%\bin\java"这一行。
//	     　　将该行注释掉 ,然后在该行下面添加如下两行并进行保存：
//	     　　copy "%JAVA_HOME%\bin\java.exe" "%JAVA_HOME%\bin\my_java.exe"
//	     　 set _RUNJAVA="%JAVA_HOME%\bin\my_java"
//	     　　注意：my_java为你所想看到的进程名字（即在任务管理器中的映像名称),其实就是拷贝一份java.exe文件,并调用拷贝的java.exe
//	     　　重启tomcat(用startup.bat启动)后在在任务管理器中看见的进程名就不再是java.exe,而是my_java.exe了。
//	     　　2、linux/unix平台：
//	     　　打开tomcat_home\bin\setclasspath.sh文件,找到_RUNJAVA="$JRE_HOME"/bin/java这一行,
//	     　　并注释掉,然后在该行下面添加如两行并进行保存：
//	     　　cp "$JAVA_HOME/bin/java" "$JAVA_HOME/bin/my_java"
//	     _RUNJAVA="$JRE_HOME/bin/my_java"
//	     　　重启tomcat,在终端输入ps -ef|grep my_java 进行查看
	       try { 
	           java.lang.Process p = Runtime.getRuntime().exec("tasklist"); 
	           in = new BufferedReader(new InputStreamReader(p.getInputStream())); 
	           
	           while ((s = in.readLine()) != null) { 
	        	   System.out.println(s);
	              if (s.startsWith(t)) { 
	                  isTomcatAlive = true; 
	                  break; 
	              } 
	           } 
	           in.close(); 
	       } catch (Exception e) { 
	           e.printStackTrace(); 
	       } 
	 
	       if (isTomcatAlive) { 
	           System.out.println("<" + new Date()+ "> Tomcat is alive but not response!"); 
	           stopTomcat(); 
	       } 
//	       startTomcat(); 
	    } 
	 
	  
	    public void startTomcat() {
	    	Tomcat tom = new Tomcat();
	    	tom.startBatByProcess();
			
	    }
	 
	    public void stopTomcat() { 
	    	Tomcat tom = new Tomcat();
	    	tom.stopBatByprocess();
	    } 
	 
	  
	 
//	    public static void startTomcat() { 
//	 
//	       try { 
//	 
//	           java.lang.Process p = java.lang.Runtime.getRuntime().exec("net stop \"Apache Tomcat\""); 
//	 
//	       } catch (Exception e) { 
//	 
//	           e.printStackTrace(); 
//	 
//	       } 
//	 
//	       try { 
//	 
//	           java.lang.Process p = java.lang.Runtime.getRuntime().exec( 
//	 
//	                  "net start \"Apache Tomcat\""); 
//	 
//	           java.io.BufferedReader in = new java.io.BufferedReader( 
//	 
//	                  new java.io.InputStreamReader(p.getInputStream())); 
//	 
//	           String s; 
//	 
//	           String t = "启动成功"; 
//	 
//	           boolean restart = false; 
//	 
//	           while ((s = in.readLine()) != null) { 
//	 
//	              if (s.indexOf(t) != -1) { 
//	 
//	                  restart = true; 
//	 
//	                  break; 
//	 
//	              } 
//	 
//	           } 
//	 
//	           System.out.println("<" + new Date() + "> Tomcat is start " 
//	 
//	                  + (restart ? "OK" : "ERROR")); 
//	 
//	       } catch (Exception e) { 
//	 
//	           e.printStackTrace(); 
//	 
//	       } 
//	 
//	    } 
	 
	  
	 
	    public static void main(String[] args) { 
//	       while (true) { 
	           try { 
	        	   MonitorTomcat mt = new MonitorTomcat();
	        	   mt.keepTomcatAlive(); 
//	              Thread.sleep(30000); 
	           } catch (Exception ex) {
	        	   ex.printStackTrace();
	           } 
//	       } 
	    }
}
