package com.activemq.topic_PERSISTENT;

import org.apache.activemq.ActiveMQConnectionFactory;   
import javax.jms.*;   
public class TopicSubscriber_1 {     
	public static void main(String[] args) throws JMSException {         
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");         
		Connection connection = factory.createConnection();        
		connection.start();                   
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);         
		Topic topic = session.createTopic("myTopic.messages");           
		MessageConsumer consumer = session.createConsumer(topic);   
//		MessageConsumer consumer = session.createDurableSubscriber(topic, "sub1");//≥÷æ√ªØ…Ë÷√
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

