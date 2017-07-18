package com.opslab.blog.admin.listener;

import com.opslab.blog.admin.listener.init.InitImage;
import com.opslab.blog.admin.service.UploadGroupService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContext;

/**
 * 应用出现初始化
 */
@Component
public class AppInitListener implements ApplicationListener, ServletContextAware {
    public static Logger logger = LogManager.getLogger(AppInitListener.class);

    @Autowired
    private ServletContext context;

    public void setServletContext(ServletContext context) {
        this.context = context;
    }

    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) if (context != null &&
                ((XmlWebApplicationContext) event.getSource())
                        .getDisplayName()
                        .equals("Root WebApplicationContext")) {
                InitImage.init();
        }
    }
}
