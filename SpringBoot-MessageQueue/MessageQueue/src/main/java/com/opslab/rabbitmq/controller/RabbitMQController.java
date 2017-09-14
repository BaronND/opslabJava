package com.opslab.rabbitmq.controller;

import com.opslab.App;
import com.opslab.rabbitmq.spring.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 0opslab
 */
@Controller
@RequestMapping("/rabbitmq")
@EnableAutoConfiguration
public class RabbitMQController {
    @Autowired
    Sender sender;

    @RequestMapping("send/{message}")
    @ResponseBody
    public String sendMessage(@PathVariable("message") String message) {
        sender.send(App.RABBITMQ_QUEUE_NAME,message);
        return App.SUCCESS;
    }
}