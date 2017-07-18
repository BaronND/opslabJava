package com.opslab.workflow.framework.service.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 利用SpringAOP定时任务的日志记录
 */
public class TaskInterceptor {
	//@Resource(name="taskLogService")
	//@Getter @Setter private TaskLogService taskLogService;
	
	public Object logAop(ProceedingJoinPoint pjp){
		/*
		TaskLog log = new TaskLog();
		boolean isSave = true;
		try{
			String className = pjp.getTarget().getClass().getName();
			String opeationName = pjp.getSignature().getName();
			Method meths[] = pjp.getSignature().getDeclaringType().getMethods();
			if(className.contains("springframework")){
				Object ret = pjp.proceed();
				isSave=false;
				return ret;
			}
			for(Method  m:meths){
				if(opeationName.equals(m.getName())){
					if(m.isAnnotationPresent(ServiceMethod.class)){
						ServiceMethod annotation = m.getAnnotation(ServiceMethod.class);
						log.setTaskName(annotation.name());
						log.setCodeId(className+"::"+opeationName);
						log.setParams(StringUtil.arr2Str(pjp.getArgs()));
						log.setTaskType(annotation.type().toString());
						log.setStartTime(new Date());
						Object ret = pjp.proceed();
						log.setResult("success");
						if(ret != null){
							if(ret.toString().length() > 200){
								log.setMsg(ret.toString().substring(0,200));
							}
						}
						return ret ;
					}else{
						log.setCodeId("该方法无注解将,不会执行"+"::"+className+"::"+opeationName);
						log.setTaskType(ServiceType.NONE.toString());
						return null;
					}
				}
			}
		}catch(Throwable e){
			e.printStackTrace();
		}finally{
			if(isSave){
				taskLogService.save(log);
			}
			
		}*/
		return null;

	}

}
