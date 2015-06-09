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
		// ConnectionFactory �����ӹ�����JMS ������������
		ConnectionFactory connectionFactory;
		// Connection ��JMS �ͻ��˵�JMS Provider ������
		Connection connection = null;
		// Session�� һ�����ͻ������Ϣ���߳�
		Session session;
		// Destination ����Ϣ��Ŀ�ĵ�;��Ϣ���͸�˭.
		Destination destination;
		// �����ߣ���Ϣ������
		MessageConsumer consumer;
		connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		try {
			// ����ӹ����õ����Ӷ���
			connection = connectionFactory.createConnection();
			// ����
			connection.start();
			// ��ȡ��������
			session = connection.createSession(Boolean.FALSE,
					Session.AUTO_ACKNOWLEDGE);
			// ��ȡsessionע�����ֵxingbo.xu-queue��һ����������queue��������ActiveMq��console����
			destination = session.createQueue("FirstQueue");
			consumer = session.createConsumer(destination);
			
			//����ģʽ
			consumer.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message msg) {
					TextMessage message = (TextMessage)msg;                     
					try{                         
						System.out.println("������Ϣ���� " + message.getText()+"��");                       
					}catch(Exception e){                         
						e.printStackTrace();                     
					} 
				}
			});
			
			//�ȴ�������Ϣ   
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