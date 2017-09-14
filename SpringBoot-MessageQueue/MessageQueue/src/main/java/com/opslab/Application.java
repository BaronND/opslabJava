package com.opslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot的启动方法
 */
//使用该注解表示启动spring的主动扫描和自动注入功能
//早起的版本中需要写@Configuration、@ComponentScan、@EnableAutoConfiguration三个注解才行
@SpringBootApplication
public class Application {

    /**
     * 通过Spring boot启动Spring应用
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");
    }
}
