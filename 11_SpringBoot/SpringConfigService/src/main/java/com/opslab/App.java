package com.opslab;


import org.springframework.boot.SpringApplication;

@org.springframework.context.annotation.Configuration
@org.springframework.boot.autoconfigure.EnableAutoConfiguration
@org.springframework.web.bind.annotation.RestController
@org.springframework.cloud.config.server.EnableConfigServer
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
