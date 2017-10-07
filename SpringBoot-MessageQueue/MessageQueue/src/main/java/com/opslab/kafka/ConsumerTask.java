package com.opslab.kafka;

import com.google.common.collect.Lists;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.List;
import java.util.Properties;

/**
 * Created by 0opslab
 */
public class ConsumerTask implements Runnable{

    private String name;

    public ConsumerTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        List<String> topics = Lists.newArrayList("test");
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "consumer");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        //订阅主题
        consumer.subscribe(topics);
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(100);
            if(!records.isEmpty()){
                for (ConsumerRecord<String, String> record : records){
                    System.out.printf("我是订阅者（消费者"+name+"）：offset = %d, key = %s, value = %s\n",
                            record.offset(), record.key(), record.value());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new ConsumerTask("consumer-" + i));
            thread.start();
        }
        Thread.sleep(Integer.MAX_VALUE);
    }
}
