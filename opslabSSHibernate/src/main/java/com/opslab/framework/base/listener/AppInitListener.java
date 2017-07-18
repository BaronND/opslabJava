package com.opslab.framework.base.listener;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.opslab.APP;
import com.opslab.framework.InitApplication;

/**
 * @author 0opslab
 * 在application中初始化一些数据
 *
 */

@Component
@SuppressWarnings("rawtypes")
public class AppInitListener implements ApplicationListener, ServletContextAware {
    private ServletContext context;

    @Override
    public void setServletContext(ServletContext context) {
        this.context = context;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            if (context != null &&
                    ((XmlWebApplicationContext) event.getSource())
                            .getDisplayName()
                            .equals("Root WebApplicationContext")) {

                APP.CLASS_PATH = this.getClass().getClassLoader()
                        .getResource("/").getPath();

                //初始化到Application中!!!!
                //context.setAttribute("all_rights_map", right_map);
                InitApplication.logo();
            }
        }
    }
}
