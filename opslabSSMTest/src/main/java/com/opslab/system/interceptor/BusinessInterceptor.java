package com.opslab.system.interceptor;

import com.opslab.business.model.BusinessLog;
import com.opslab.business.service.BusinessLogService;
import com.opslab.system.annotion.ServiceMethod;
import com.opslab.util.JacksonUtil;
import com.opslab.util.RandomUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 利用AOP切入记录业务日志
 */
public class BusinessInterceptor {
    private static Logger logger = Logger.getLogger(BusinessInterceptor.class);

    @Resource(name = "businessLogService")
    private BusinessLogService businessLogService;

    public Object logAop(ProceedingJoinPoint pjp) {
        BusinessLog log = new BusinessLog(RandomUtil.uuid());

        String className = pjp.getTarget().getClass().getName();
        String operationName = pjp.getSignature().getName();
        //操作类级方法
        log.setOperationName(className + "::" + operationName);
        //操作参数
        log.setOperationParam(JacksonUtil.toJSON(pjp.getArgs()));

        try {
            HttpSession session =
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
                            getRequest().getSession();
            if (session != null) {
                String userCode = (String) session.getAttribute("user_code");
                log.setUserName(userCode);
            }
        } catch (NullPointerException e) {
            //跑测试的时候可能没有用http 去跑可能为空
        }

        try {
            Method meths[] = pjp.getSignature().getDeclaringType().getMethods();
            for (Method m : meths) {
                if (operationName.equals(m.getName())) {
                    if (m.isAnnotationPresent(ServiceMethod.class)) {
                        ServiceMethod annotation = m.getAnnotation(ServiceMethod.class);
                        log.setBusinessName(annotation.value());
                        log.setType(annotation.type().toString());
                    } else {
                        log.setBusinessName("NOTSIGNATURE");
                        log.setType("NOTSIGNATURE");
                        //业务层方法无签名不予执行
                        logger.error("PLEASE SIGNATURE:" + className + "::" + operationName);
                        return null;
                    }
                }
            }


            Object ret = pjp.proceed();
            //设置操作结果
            log.setResult("success");
            //设置结果消息
            if (ret != null) {
                if (ret.toString().length() > 200) {
                    log.setMsg(ret.toString().substring(0, 200));
                }
            }
            return ret;
        } catch (Throwable e) {
            e.printStackTrace();
            log.setResult("exception");
            String msg = e.getMessage();
            if (msg.length() > 200) {
                msg = msg.substring(0, 200);
            }
            log.setMsg(msg);
            return null;
        } finally {
            businessLogService.saveLog(log);
        }
    }
}
