package com.opslab.activemq;

import com.opslab.App;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息发布者
 */
public class Pub {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                App.ACTIVEMQ_CONNECTION);
        Connection connection = null;
        try {
            //创建连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();

            //获取session
            Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

            //创建主题
            Topic firstTopic = session.createTopic("FirstTopic");

            MessageProducer producer = session.createProducer(firstTopic);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            for (int i = 0; i < 100; i++) {
                TextMessage message = session.createTextMessage();
                message.setText("message_hello"+i);
                producer.send(message);
            }

            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
