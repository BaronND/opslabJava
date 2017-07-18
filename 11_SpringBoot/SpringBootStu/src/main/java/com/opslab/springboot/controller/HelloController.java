package com.opslab.springboot.controller;

import com.opslab.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by neptune on 2017/3/27 0027.
 */
@Controller
@RequestMapping("/hello")
@EnableAutoConfiguration
public class HelloController {

    @Autowired
    HelloService service;

    @RequestMapping("index")
    @ResponseBody
    public String hello() {
        return "Hello spring boot";
    }


    @RequestMapping("service")
    @ResponseBody
    public String helloSay(){
        return service.say();
    }
}
