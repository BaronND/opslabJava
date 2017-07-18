package com.opslab.controller;

import com.opslab.domain.UserInfo;
import com.opslab.service.HelloService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/hello")
@EnableAutoConfiguration
public class HelloController {
    private static Logger logger = LogManager.getLogger(HelloController.class);
    @Resource(name ="helloService")
    private HelloService service;

    @RequestMapping("index")
    @ResponseBody
    public String hello() {
        logger.info("log4j2 test");
        return "Hello spring boot";
    }

    @RequestMapping("properties")
    @ResponseBody
    public String properties() {
        return service.sayHello();
    }

    @RequestMapping("list")
    @ResponseBody
    public List<UserInfo> list() {
        return service.userInfo();
    }
}
