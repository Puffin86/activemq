package com.activemq.point2point;

import javax.jms.Message;
import javax.jms.MessageListener;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Receiver_listener {
	public static void main(String[] args) {
		boolean stop = false; 
		// ConnectionFactory ：连接工厂，JMS 用它创建连接
		ConnectionFactory connectionFactory;
		// Connection ：JMS 客户端到JMS Provider 的连接
		Connection connection = null;
		// Session： 一个发送或接收消息的线程
		Session session;
		// Destination ：消息的目的地;消息发送给谁.
		Destination destination;
		// 消费者，消息接收者
		MessageConsumer consumer;
		connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		try {
			// 构造从工厂得到连接对象
			connection = connectionFactory.createConnection();
			// 启动
			connection.start();
			// 获取操作连接
			session = connection.createSession(Boolean.FALSE,
					Session.AUTO_ACKNOWLEDGE);
			// 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
			destination = session.createQueue("FirstQueue");
			consumer = session.createConsumer(destination);
			
			//监听模式
			consumer.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message msg) {
					TextMessage message = (TextMessage)msg;                     
					try{                         
						System.out.println("接收消息：《 " + message.getText()+"》");                       
					}catch(Exception e){                         
						e.printStackTrace();                     
					} 
				}
			});
			
			//等待接收消息   
	        while(!stop){   
	            Thread.sleep(15000);   
	        }  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != connection)
					connection.close();
			} catch (Throwable ignore) {
			}
		}
	}
}
