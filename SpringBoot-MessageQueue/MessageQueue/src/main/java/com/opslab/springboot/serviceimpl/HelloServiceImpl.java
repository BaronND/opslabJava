package com.opslab.springboot.serviceimpl;

import com.opslab.springboot.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * 实现操作接口
 */
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public String say() {
        return "Hello Say";
    }
}
