package com.opslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring/SpringApplication-core.xml"})
public class SpringMybatisServiceApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringMybatisServiceApplication.class);
		app.run(args);
    }
}
