package com.opslab;


public class App {
    //操作失败
    public static final String ERROR = "error";
    //操作成功
    public static final String SUCCESS = "success";

    // rabbitmq的消息队列名称
    public static final String RABBITMQ_QUEUE_NAME = "Message-queue";

    // activemq连接消息队列
    public static String ACTIVEMQ_CONNECTION = "tcp://localhost:61616";

}
