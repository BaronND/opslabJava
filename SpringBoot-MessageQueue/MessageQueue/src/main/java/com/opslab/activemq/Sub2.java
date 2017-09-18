package com.opslab.activemq;

import com.opslab.App;
import com.opslab.App;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息订阅者
 */
public class Sub2 implements  MessageListener {
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

            //创建消息的订阅者
            MessageConsumer consumer = session.createConsumer(firstTopic);
            consumer.setMessageListener(new Sub2());

            Thread.sleep(1000*60*24);
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


    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage)message;
        try {
            System.out.println("消息订阅者接受到信息:"+ tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
