package com.opslab.framework.base.service.interceptor;

import com.opslab.APP;
import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.annotation.ServiceType;
import com.opslab.framework.base.entity.TaskLog;
import com.opslab.framework.base.service.TaskLogService;
import com.opslab.util.ExceptionUtil;
import com.opslab.util.JacksonUtil;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 利用SpringAOP定时任务的日志记录
 */
public class TaskInterceptor {
    @Resource(name = "taskLogService")
    private TaskLogService taskLogService;

    public Object logAop(ProceedingJoinPoint pjp) {
        TaskLog log = new TaskLog();
        boolean isSave = true;
        try {
            String className = pjp.getTarget().getClass().getName();
            String opeationName = pjp.getSignature().getName();
            Method meths[] = pjp.getSignature().getDeclaringType().getMethods();
            for (Method m : meths) {
                if (opeationName.equals(m.getName())) {
                    if (m.isAnnotationPresent(ServiceMethod.class)) {
                        ServiceMethod annotation = m.getAnnotation(ServiceMethod.class);
                        log.setTaskName(annotation.value());
                        log.setOperationName(className + "::" + opeationName);
                        log.setOperationParam(JacksonUtil.toJSON(pjp.getArgs()));
                        log.setTaskType(annotation.type().toString());
                        log.setStartTime(new Date());
                        Object ret = pjp.proceed();
                        log.setResult("success");
                        return ret;
                    } else {
                        log.setOperationName("该方法无注解将,不会执行" + "::" + className + "::" + opeationName);
                        log.setTaskType(ServiceType.NONE.toString());
                        return null;
                    }
                }
            }
        } catch (Throwable e) {
            log.setResult("exception");
            log.setMsg(ExceptionUtil.stackTraceToString(e, APP.PACKAGE_NAME));
        } finally {
            taskLogService.save(log);
        }
        return null;
    }

}
