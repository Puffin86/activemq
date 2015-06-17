package com.util;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;

public class Windows {
	
	
	public static void main(String[] args){
		
		Windows win = new Windows();
//		win.getJavaEnvInfo();
		win.getCpuInfo();
	}
	
	
	public void getJavaEnvInfo() {
		try{
			Runtime r = Runtime.getRuntime();
	        Properties props = System.getProperties();
	        InetAddress addr= InetAddress.getLocalHost();
	        String ip = addr.getHostAddress();
	        Map<String, String> map = System.getenv();
	        String userName = map.get("USERNAME");// ��ȡ�û���
	        String computerName = map.get("COMPUTERNAME");// ��ȡ�������
	        String userDomain = map.get("USERDOMAIN");// ��ȡ���������
	        System.out.println("�û���:    " + userName);
	        System.out.println("�������:    " + computerName);
	        System.out.println("���������:    " + userDomain);
	        System.out.println("����ip��ַ:    " + ip);
	        System.out.println("����������:    " + addr.getHostName());
	        System.out.println("JVM����ʹ�õ����ڴ�:    " + r.totalMemory());
	        System.out.println("JVM����ʹ�õ�ʣ���ڴ�:    " + r.freeMemory());
	        System.out.println("JVM����ʹ�õĴ���������:    " + r.availableProcessors());
	        System.out.println("Java�����л����汾��    " + props.getProperty("java.version"));
	        System.out.println("Java�����л�����Ӧ�̣�    " + props.getProperty("java.vendor"));
	        System.out.println("Java��Ӧ�̵�URL��    " + props.getProperty("java.vendor.url"));
	        System.out.println("Java�İ�װ·����    " + props.getProperty("java.home"));
	        System.out.println("Java��������淶�汾��    " + props.getProperty("java.vm.specification.version"));
	        System.out.println("Java��������淶��Ӧ�̣�    " + props.getProperty("java.vm.specification.vendor"));
	        System.out.println("Java��������淶���ƣ�    " + props.getProperty("java.vm.specification.name"));
	        System.out.println("Java�������ʵ�ְ汾��    " + props.getProperty("java.vm.version"));
	        System.out.println("Java�������ʵ�ֹ�Ӧ�̣�    " + props.getProperty("java.vm.vendor"));
	        System.out.println("Java�������ʵ�����ƣ�    " + props.getProperty("java.vm.name"));
	        System.out.println("Java����ʱ�����淶�汾��    " + props.getProperty("java.specification.version"));
	        System.out.println("Java����ʱ�����淶��Ӧ�̣�    " + props.getProperty("java.specification.vender"));
	        System.out.println("Java����ʱ�����淶���ƣ�    " + props.getProperty("java.specification.name"));
	        System.out.println("Java�����ʽ�汾�ţ�    " + props.getProperty("java.class.version"));
	        System.out.println("Java����·����    " + props.getProperty("java.class.path"));
	        System.out.println("���ؿ�ʱ������·���б���    " + props.getProperty("java.library.path"));
	        System.out.println("Ĭ�ϵ���ʱ�ļ�·����    " + props.getProperty("java.io.tmpdir"));
	        System.out.println("һ��������չĿ¼��·����    " + props.getProperty("java.ext.dirs"));
	        System.out.println("����ϵͳ�����ƣ�    " + props.getProperty("os.name"));
	        System.out.println("����ϵͳ�Ĺ��ܣ�    " + props.getProperty("os.arch"));
	        System.out.println("����ϵͳ�İ汾��    " + props.getProperty("os.version"));
	        System.out.println("�ļ��ָ�����    " + props.getProperty("file.separator"));
	        System.out.println("·���ָ�����    " + props.getProperty("path.separator"));
	        System.out.println("�зָ�����    " + props.getProperty("line.separator"));
	        System.out.println("�û����˻����ƣ�    " + props.getProperty("user.name"));
	        System.out.println("�û�����Ŀ¼��    " + props.getProperty("user.home"));
	        System.out.println("�û��ĵ�ǰ����Ŀ¼��    " + props.getProperty("user.dir"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getCpuInfo(){
//		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
//		  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
//		    method.setAccessible(true);
//		    if (method.getName().startsWith("get") 
//		        && Modifier.isPublic(method.getModifiers())) {
//		            Object value;
//		        try {
//		            value = method.invoke(operatingSystemMXBean);
//		        } catch (Exception e) {
//		            value = e;
//		        } // try
//		        System.out.println(method.getName() + " = " + value);
//		    } // if
//		  } // for
		
		int kb=1024;
		Runtime rt = Runtime.getRuntime();
		long totalMemory = rt.totalMemory()/kb;
		long freeMemory = rt.freeMemory()/kb;
		long maxMemory = Runtime.getRuntime().maxMemory() / kb;
		
		System.out.println(totalMemory+"@"+freeMemory+"@"+maxMemory);
		OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		// �ܵ������ڴ�    
//        long totalMemorySize = osmxb.getTotalPhysicalMemorySize() / kb;    
//        // ʣ��������ڴ�    
//        long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize() / kb;    
//        // ��ʹ�õ������ڴ�    
//        long usedMemory = (osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize())/ kb;    

	}
	
	public void getMemoryInfo(){
		OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		  // �ܵ������ڴ�+�����ڴ�
//		  long totalvirtualMemory = osmxb.getTotalSwapSpaceSize();
//		  // ʣ��������ڴ�
//		  long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
//		  Double compare=(Double)(1-freePhysicalMemorySize*1.0/totalvirtualMemory)*100;
//		  String str="�ڴ���ʹ��:"+compare.intValue()+"%";

	}
	
}