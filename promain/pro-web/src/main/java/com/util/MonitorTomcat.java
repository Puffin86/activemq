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
	                  // ����ܹ���ȡ��ҳ����֤��tomcat������ֱ��return
	                  return; 
	              } 
	           } 
	           in.close(); 
	       } catch (Exception ex) { 
	    	   ex.printStackTrace();
	       } 
	 
	       //�жϽ������Ƿ��и�tomcat����
	       //������ɫ�汾��tomcat����ͳһ������jave.exe,����ͨ���޸Ľ�������ʶ���޸ķ����ο�
//	    1��windowƽ̨��
//	     ������tomcat_home\bin\setclasspath.bat�ļ����ҵ�set _RUNJAVA="%JRE_HOME%\bin\java"��һ�С�
//	     ����������ע�͵� ,Ȼ���ڸ�����������������в����б��棺
//	     ����copy "%JAVA_HOME%\bin\java.exe" "%JAVA_HOME%\bin\my_java.exe"
//	     �� set _RUNJAVA="%JAVA_HOME%\bin\my_java"
//	     ����ע�⣺my_javaΪ�����뿴���Ľ������֣���������������е�ӳ������),��ʵ���ǿ���һ��java.exe�ļ�,�����ÿ�����java.exe
//	     ��������tomcat(��startup.bat����)����������������п����Ľ������Ͳ�����java.exe,����my_java.exe�ˡ�
//	     ����2��linux/unixƽ̨��
//	     ������tomcat_home\bin\setclasspath.sh�ļ�,�ҵ�_RUNJAVA="$JRE_HOME"/bin/java��һ��,
//	     ������ע�͵�,Ȼ���ڸ���������������в����б��棺
//	     ����cp "$JAVA_HOME/bin/java" "$JAVA_HOME/bin/my_java"
//	     _RUNJAVA="$JRE_HOME/bin/my_java"
//	     ��������tomcat,���ն�����ps -ef|grep my_java ���в鿴
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
//	           String t = "�����ɹ�"; 
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
