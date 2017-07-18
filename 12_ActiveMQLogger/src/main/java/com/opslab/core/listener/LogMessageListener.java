package com.opslab.core.listener;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.opslab.core.model.BusinessLog;
import com.opslab.core.service.BusinessLogService;
import com.opslab.core.util.JacksonUtil;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 用于处理ActiveMQ的消息
 */
@Component("logMessageListener")
public class LogMessageListener implements MessageListener {
    private Logger logger = Logger.getLogger(LogMessageListener.class);

    @Resource(name = "businessLogService")
    private BusinessLogService service;

    public void onMessage(Message message) {
        BusinessLog businessLog = null;
        try {
            ActiveMQObjectMessage msg = (ActiveMQObjectMessage)message;
            LoggingEvent event =
                    (LoggingEvent)((ActiveMQObjectMessage)message).getObject();
            String clientId = msg.getConnection().getClientID();
            Date createDate = new Date(event.timeStamp);
            String className = event.categoryName;
            String level = event.getLevel().toString();
            String msgContent = event.getRenderedMessage();
            businessLog = new BusinessLog(createDate, clientId, "", className, level, msgContent);
            logger.debug(JacksonUtil.toJSON(businessLog));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(businessLog != null){
                service.saveLog(businessLog);
            }
        }
    }
}

