package com.opslab.rabbitmq.spring;

import com.opslab.App;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue(App.RABBITMQ_QUEUE_NAME);
    }
}