package com.activemq.topic_NON_PERSISTENT;

import org.apache.activemq.ActiveMQConnectionFactory;   
import javax.jms.*;   
/**
 * activemq����ģʽ���־û���
 * 1��һ�������߶�Ӧ���������
 * 2�������߷��͵���Ϣ������������֮ǰ�Ļᶪʧ
 * 3����;���������ʧȥ�����ٴ�������ʱ����Ȼ���Խ��ܵ�֮ǰ�����߷�������Ϣ������ָ�������ߵ�ID
 * @author shaobaitong
 *
 */
public class TopicPublisher_NON {     
	public static void main(String[] args) throws JMSException {         
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");         
		Connection connection = factory.createConnection();         
		connection.start();                   
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);         
		Topic topic = session.createTopic("myTopicPersistent.messages");           
		MessageProducer producer = session.createProducer(topic);         
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);//�־û����� 
		int i = 0;
		while(true) {           
			i++;
			TextMessage message = session.createTextMessage();             
			message.setText("message_non_persistent=" + i); 
			producer.send(message);             
			System.out.println("Sent message: " + message.getText());               
			try {                 
				Thread.sleep(3000);             
			} catch (InterruptedException e) {                 
				e.printStackTrace();             
			}         
		}   
//      session.close(); 
//      connection.stop(); 
//      connection.close();
	}
}


