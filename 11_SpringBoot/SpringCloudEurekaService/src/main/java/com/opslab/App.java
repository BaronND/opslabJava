package com.opslab;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication

/**
 *  启动一个服务注册中心提供给其他应用进行对话
 */
public class App {
    public static void main( String[] args ) {
        //下面两行代码都可以用来启动
        SpringApplication.run(App.class, args);
    }
}
