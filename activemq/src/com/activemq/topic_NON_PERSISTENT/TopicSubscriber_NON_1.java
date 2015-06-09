package com.activemq.topic_NON_PERSISTENT;

import org.apache.activemq.ActiveMQConnectionFactory;   
import javax.jms.*;   
public class TopicSubscriber_NON_1 {     
	public static void main(String[] args) throws JMSException {         
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");         
		Connection connection = factory.createConnection();     
		connection.setClientID("sub1");//持久化设置 
		connection.start();                   
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);         
		Topic topic = session.createTopic("myTopicPersistent.messages");           
		MessageConsumer consumer = session.createDurableSubscriber(topic, "sub1");//持久化设置
		consumer.setMessageListener(new MessageListener() {             
			public void onMessage(Message message) {                 
				TextMessage tm = (TextMessage) message;                 
				try {                     
					System.out.println("Received_1 message: " + tm.getText());                 
				} catch (JMSException e) {                     
					e.printStackTrace();                 
				}             
			}         
		}); 
//      session.close(); 
//      connection.stop(); 
//      connection.close();     
	}
}

