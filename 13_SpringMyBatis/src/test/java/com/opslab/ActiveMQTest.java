package com.opslab;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
/**
 * 测试ActiveMQ服务
 */
public class ActiveMQTest {
    // log a message
    Logger logger = Logger.getLogger(ActiveMQTest.class);

    MessageConsumer consumer;
    Session session;
    Connection connection;

    public ActiveMQTest() throws Exception {
        // create consumer and listen queue
        ActiveMQConnectionFactory factory =
                new ActiveMQConnectionFactory("tomcat1","","tcp://localhost:61616");
        factory.setClientID("10001");
        connection = factory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        connection.start();
        //////////////注意这里JMSAppender只支持TopicDestination，下面会说到////////////////
        Destination topicDestination = session.createTopic("logTopic");
        consumer = session.createConsumer(topicDestination);
        //consumer.setMessageListener(this);




    }

    public void run(){
        for (int i = 0; i < 10000; i++) {
            logger.info("Info Log.");
            logger.warn("Warn Log");
            logger.error("Error Log.");
        }
    }

    public void clean() throws JMSException {
        consumer.close();
        session.close();
        connection.close();
        System.exit(1);
    }


    public static void main(String[] args) throws Exception {
        ActiveMQTest activeMQTest = new ActiveMQTest();
        activeMQTest.run();
        activeMQTest.clean();
    }


}
