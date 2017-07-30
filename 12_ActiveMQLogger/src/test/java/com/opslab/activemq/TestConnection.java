package com.opslab.activemq;

import com.opslab.APP;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 测试是否能正常连接的ActiveMQ
 */
public class TestConnection {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory =
                new ActiveMQConnectionFactory(APP.ACTIVEMQ_CONNECTION);
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        connection.start();
        Queue destination = session.createQueue("FirstQueue");
        // 得到消息生成者【发送者】
        MessageProducer producer = session.createProducer(destination);
        // 设置不持久化，此处学习，实际根据项目决定
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        // 构造消息，此处写死，项目就是参数，或者方法获取
        for (int i = 1; i <= 10; i++) {
            TextMessage message = session.createTextMessage("ActiveMq 发送的消息" + i);
            // 发送消息到目的地方
            System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
            producer.send(message);
        }
        session.commit();
    }
}
