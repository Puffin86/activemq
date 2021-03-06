package com.activemq.topic_PERSISTENT;

import org.apache.activemq.ActiveMQConnectionFactory;   
import javax.jms.*;   
public class TopicSubscriber_2 {     
	public static void main(String[] args) throws JMSException {         
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");         
		Connection connection = factory.createConnection();         
		connection.start();                   
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);         
		Topic topic = session.createTopic("myTopic.messages");           
		MessageConsumer consumer = session.createConsumer(topic);         
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

