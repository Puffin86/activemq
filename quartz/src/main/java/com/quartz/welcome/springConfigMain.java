package com.quartz.welcome;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.quartz.job.QuartzJob;

public class springConfigMain {
	public static void main(String[] args){
			 //ͨ��schedulerFactory��ȡһ��������
			   SchedulerFactory schedulerfactory=new StdSchedulerFactory();
			   Scheduler scheduler=null;
			   try{
//				ͨ��schedulerFactory��ȡһ��������
				   scheduler=schedulerfactory.getScheduler();
//				 ����jobDetailʵ������Jobʵ����
//				 ָ��job�����ƣ�����������ƣ��Լ���job��
				   JobDetail job=JobBuilder.newJob(QuartzJob.class).withIdentity("jobkey", "jobgroupkey").build();
//				 ������ȴ�������
//				ʹ��simpleTrigger����
					  Trigger trigger=TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroupkey")
			          .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?"))
			          .startNow().build(); 
//				 ����ҵ�ʹ�����ע�ᵽ���������
				   scheduler.scheduleJob(job, trigger);
//				 ��������
				   scheduler.start();
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   
	}
}
