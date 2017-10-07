package com.opslab.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * Created by 0opslab
 */
public class AsyncProducer {

    private static boolean isAsync = true;

    private static String topic = "test";
    public static void main(String[] args) throws InterruptedException {


        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<String,String>(props);
        for (int i = 0; i < 100; i++) {
            if (isAsync) {
                producer.send(new ProducerRecord(topic, String.valueOf(i), "message>"+i),
                        new DemoCallBack(System.currentTimeMillis(), i, "message>"+i));
            } else {
                try {
                    producer.send(new ProducerRecord(topic, String.valueOf(i), "message>"+i)).get();
                    System.out.println("send message: (" + i + ", "+ "message>"+i + ")");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        Thread.sleep(Integer.MAX_VALUE);
    }


    static class DemoCallBack implements Callback {
        private final long startTime;
        private final int key;
        private final String message;

        public DemoCallBack(long startTime, int key, String message) {
            this.startTime = startTime;
            this.key = key;
            this.message = message;
        }

        /**
         * @param metadata  生产者发送的元数据，发送过程中出现异常此参数为null
         * @param exception 发送过程出现的异常，如发送成功，则该参数为null
         */
        public void onCompletion(RecordMetadata metadata, Exception exception) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (metadata != null) {
                // metadata中包含了分区信息、offset信息等
                System.out.println("message(" + key + ", " + message
                        + ") sent to partition(" + metadata.partition() + "), "
                        + "offset(" + metadata.offset() + ") in " + elapsedTime
                        + "ms");
            } else {
                exception.printStackTrace();
            }
        }
    }
}
