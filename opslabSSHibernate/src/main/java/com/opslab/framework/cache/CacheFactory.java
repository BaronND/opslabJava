package com.opslab.framework.cache;

import com.opslab.framework.base.entity.GeneralCode;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

/**
 * 缓存相关的工厂类
 */
public class CacheFactory {

    public static CommonCache codeCache(){
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        return (CommonCache) wac.getBean("commonCache");
    }

}
