package com.opslab.framework.base.service.interceptor;

import com.opslab.APP;
import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.annotation.ServiceType;
import com.opslab.framework.base.entity.BusinessLog;
import com.opslab.framework.base.service.BusinessLogService;
import com.opslab.util.DateUtil;
import com.opslab.util.ExceptionUtil;
import com.opslab.util.JacksonUtil;
import com.opslab.util.RandomUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;


/**
 * 利用SpringAOP实现业务层的日志记录
 */
public class ServiceInterceptor {

    private static Logger logger = Logger.getLogger(ServiceInterceptor.class);

    @Resource(name = "businessLogService")
    private BusinessLogService businessLogService;


    public Object logAop(ProceedingJoinPoint pjp) {
        BusinessLog log = new BusinessLog(RandomUtil.uuid());
        log.setStartTime(DateUtil.currentDateTime());
        try {
            //获取session中的数据
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();
            HttpSession session = request.getSession();
            String userId = (String) session.getAttribute("user");
            log.setUserName(userId);
            log.setUri(request.getRequestURI());
            log.setIp(request.getRemoteAddr());
        } catch (Exception e) {
            //放置非真实web环境测试是报错
        }

        try {
            String className = pjp.getTarget().getClass().getName();
            String operationName = pjp.getSignature().getName();
            Method meths[] = pjp.getSignature().getDeclaringType().getMethods();
            for (Method m : meths) {
                if (operationName.equals(m.getName())) {
                    if (m.isAnnotationPresent(ServiceMethod.class)) {
                        ServiceMethod annotation = m.getAnnotation(ServiceMethod.class);
                        log.setBusinessName(annotation.value());
                        log.setType(annotation.type().toString());
                    } else {
                        log.setBusinessName("NOSIGNATURE");
                        log.setType(ServiceType.NONE.toString());
                    }
                }
            }
            log.setOperationName(className + "::" + operationName);
            //操作参数
            String params = JacksonUtil.toJSON(pjp.getArgs());
            params = params.substring(1,params.length()-1);
            log.setOperationParam(params);


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
            log.setResult("exception");
            String errorMsg = ExceptionUtil.stackTraceToString(e, APP.PACKAGE_NAME);
            logger.error(errorMsg);
            log.setMsg(errorMsg);
            throw new RuntimeException("业务异常:"+errorMsg);
        } finally {

            log.setEndTime(DateUtil.currentDateTime());
            businessLogService.save(log);
        }
    }
}
