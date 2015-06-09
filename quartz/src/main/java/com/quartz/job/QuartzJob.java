package com.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJob implements Job{
	private String flagStr = "local";
	
	public String getFlagStr() {
		return flagStr;
	}
	
	public void setFlagStr(String flagStr) {
		this.flagStr = flagStr;
	}
	
	//spring�����Ͷ�ʱ����ֱ�ӵ��ȷ���
	public void play(){
		System.out.println("Job is playing & job is start by "+flagStr);
	}
	
	//�����Ͷ�ʱ������ʵ��Job�ӿڲ�ʵ��execute����
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		play();
	}
	
	
	
}
