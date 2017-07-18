package com.opslab.workflow.framework.service.interceptor;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.opslab.workflow.framework.annotation.ServiceMethod;
import com.opslab.workflow.framework.annotation.ServiceType;
import com.opslab.workflow.framework.entity.business.BusinessLog;
import com.opslab.workflow.framework.service.BusinessLogService;
import com.opslab.workflow.util.StringUtil;
import com.opslab.workflow.util.sec;



/**
 * 利用SpringAOP实现业务层的日志记录
 */
public class ServiceInterceptor {

    private static Logger logger = Logger.getLogger(ServiceInterceptor.class);

    @Resource(name = "businessLogService")

    private BusinessLogService businessLogService;

    public BusinessLogService getBusinessLogService() {
		return businessLogService;
	}

	public void setBusinessLogService(BusinessLogService businessLogService) {
		this.businessLogService = businessLogService;
	}



	public Object logAop( ProceedingJoinPoint pjp ) {
        BusinessLog log = new BusinessLog(sec.uuid());
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
                        log.setBusinessName("");
                        log.setType(ServiceType.NONE.toString());
                    }
                }
            }
            log.setOperationName(className + "::" + operationName);
            //操作参数
            log.setOperationParam(StringUtil.arr2Str(pjp.getArgs()));

            //获取session中的数据
//			ActionContext context = ActionContext.getContext();
//			if(context != null){
//				Map<String, Object> session = context.getSession();
//				if(session != null){
//					User user = (User) session.get("user");
//					if(user != null){
//						log.setUserName(user.getUsername());
//					}
//				}
//				HttpServletRequest request = ServletActionContext.getRequest();
//				if(request != null){
//					String uri=request.getRequestURI();
//					String address=request.getRemoteAddr();
//					log.setAddress(address);
//					Map<String, Object> actionParam = context.getParameters();
//					StringBuffer paramters = new StringBuffer();
//					Iterator<Entry<String, Object>> iterator = actionParam.entrySet().iterator();
//					Entry<String, Object> entry;
//					while(iterator.hasNext()){
//						entry =iterator.next();
//						paramters.append("&");
//						paramters.append(entry.getKey());
//						paramters.append("=");
//						paramters.append(StringUtil.arr2Str((String[])entry.getValue()));
//					}
//					if("" != paramters.toString()){
//						log.setUri(uri);
//					}else{
//						log.setUri(uri+"?"+paramters.toString());
//					}
//
//				}
//			}
            //调用目标对象的方法
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
            businessLogService.save(log);
            logger.info("Businsss-AopLog:" + log);
        }
    }
}
