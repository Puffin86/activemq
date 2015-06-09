package com.activemq.topic_PERSISTENT;

import org.apache.activemq.ActiveMQConnectionFactory;   
import javax.jms.*;   
/**
 * activemq订阅模式（非持久化）
 * 1、一个生产者对应多个消费者
 * 2、生产者发送的消息在消费者启动之前的会丢失（非持久化）
 * 3、中途如果消费者失去连接再次连接上时，无法接受到之前生产者发布的消息
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


