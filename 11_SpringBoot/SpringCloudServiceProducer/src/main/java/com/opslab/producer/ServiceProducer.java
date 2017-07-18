package com.opslab.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 服务提交者
 * 程序启动时会将相关的服务注册到Eureka
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProducer {

    public static void main(String[] args){
        SpringApplication.run(ServiceProducer.class, args);
    }
}
