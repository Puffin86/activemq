package com.activemq.topic_PERSISTENT;

import org.apache.activemq.ActiveMQConnectionFactory;   
import javax.jms.*;   
/**
 * activemq����ģʽ���ǳ־û���
 * 1��һ�������߶�Ӧ���������
 * 2�������߷��͵���Ϣ������������֮ǰ�Ļᶪʧ���ǳ־û���
 * 3����;���������ʧȥ�����ٴ�������ʱ���޷����ܵ�֮ǰ�����߷�������Ϣ
 * @author shaobaitong
 *
 */
public class TopicPublisher {     
	public static void main(String[] args) throws JMSException {         
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");         
		Connection connection = factory.createConnection();         
		connection.start();                   
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);         
		Topic topic = session.createTopic("myTopic.messages");           
		MessageProducer producer = session.createProducer(topic);         
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);    
		int i = 0;
		while(true) {           
			i++;
			TextMessage message = session.createTextMessage();             
//			message.setText("message_" + System.currentTimeMillis());
			message.setText("message_" + i); 
			producer.send(message);             
			System.out.println("Sent message: " + message.getText());               
			try {                 
				Thread.sleep(10000);             
			} catch (InterruptedException e) {                 
				e.printStackTrace();             
			}         
		}   
//      session.close(); 
//      connection.stop(); 
//      connection.close();
	}
}


