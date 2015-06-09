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
	
	//spring配置型定时器可直接调度方法
	public void play(){
		System.out.println("Job is playing & job is start by "+flagStr);
	}
	
	//代码型定时器必须实现Job接口并实现execute方法
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		play();
	}
	
	
	
}
