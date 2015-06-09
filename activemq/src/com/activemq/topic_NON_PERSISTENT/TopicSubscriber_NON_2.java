package com.activemq.topic_NON_PERSISTENT;

import org.apache.activemq.ActiveMQConnectionFactory;   
import javax.jms.*;   
public class TopicSubscriber_NON_2 {     
	public static void main(String[] args) throws JMSException {         
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");         
		Connection connection = factory.createConnection(); 
		connection.setClientID("sub2");//�־û����� 
		connection.start();                   
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);         
		Topic topic = session.createTopic("myTopicPersistent.messages");           
		MessageConsumer consumer = session.createDurableSubscriber(topic, "sub2");//�־û����� 
		consumer.setMessageListener(new MessageListener() {             
			public void onMessage(Message message) {                 
				TextMessage tm = (TextMessage) message;                 
				try {                     
					System.out.println("Received_2 message: " + tm.getText());                 
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
