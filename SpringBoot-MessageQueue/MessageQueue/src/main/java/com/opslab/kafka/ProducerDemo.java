package com.opslab.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by 0opslab
 */
public class ProducerDemo extends Thread {

    private String topic;

    public ProducerDemo(String topic) {
        this.topic = topic;
    }

    @Override
    public void run() {
        Properties properties = new Properties();
        //声明zk
        properties.put("zookeeper.connect", "127.0.0.1:2181");
        properties.put("serializer.class", StringEncoder.class.getName());
        // 声明kafka broker
        properties.put("metadata.broker.list", "localhost:9092");
        Producer producer = new Producer<Integer, String>(new ProducerConfig(properties));

        for (int i = 0; i < 10; i++) {
            producer.send(new KeyedMessage<Integer, String>(topic, "message: " + i++));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 使用kafka集群中创建好的主题 test
        new ProducerDemo("test").start();

    }
}
