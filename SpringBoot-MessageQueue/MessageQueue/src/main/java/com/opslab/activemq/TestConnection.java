package com.opslab.activemq;

import javax.jms.*;

import com.opslab.App;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

/**
 * 测试是否能正常连接的ActiveMQ
 */
public class TestConnection implements MessageListener {

    public TestConnection() throws JMSException, InterruptedException {
        ActiveMQConnectionFactory factory =
                new ActiveMQConnectionFactory(App.ACTIVEMQ_CONNECTION);
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        connection.start();
        //////////////注意这里JMSAppender只支持TopicDestination，下面会说到////////////////
        Destination topicDestination = session.createTopic("logTopic");
        MessageConsumer consumer = session.createConsumer(topicDestination);
        consumer.setMessageListener(this);

        // log a message
        Logger logger = Logger.getLogger(TestConnection.class);
        logger.info("Info Log.");
        logger.warn("Warn Log");
        logger.error("Error Log.");

        // clean up
        Thread.sleep(1000);
        consumer.close();
        session.close();
        connection.close();
        System.exit(1);
    }

    @Override
    public void onMessage(Message message) {
        try {
            // receive log event in your consumer
            LoggingEvent event = (LoggingEvent) ((ActiveMQObjectMessage) message).getObject();
            System.out.println("Received log [" + event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, JMSException {
        new TestConnection();
    }
}
