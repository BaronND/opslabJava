package com.opslab.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String say(@RequestParam String name){
        return "com.opslab.producer.serviceImpl.HelloService say:"+name;
    }

    @RequestMapping("/list")
    public List<String> say(){
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("44");
        return list;
    }
}
